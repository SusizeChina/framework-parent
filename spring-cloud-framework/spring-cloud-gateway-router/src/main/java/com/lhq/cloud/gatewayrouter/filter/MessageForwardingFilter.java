package com.lhq.cloud.gatewayrouter.filter;

import java.nio.charset.Charset;
import java.util.List;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.lhq.cloud.core.log.LogConstants;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MessageForwardingFilter implements GlobalFilter, Ordered {
	private Logger log = LoggerFactory.getLogger(MessageForwardingFilter.class);

	@Override
	public int getOrder() {
		// <-1
		return -1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("MessageForwardingFilterBefore{}");
		String scheme = exchange.getRequest().getURI().getScheme();
		if (!"http".equals(scheme) && !"https".equals(scheme)) {
			return chain.filter(exchange);
		}
		// 请求转发
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		List<String> list = headers.get(LogConstants.HTTP_HEADER_TRACE_ID);
		// 响应转发
		ServerHttpResponse originalResponse = exchange.getResponse();
		DataBufferFactory bufferFactory = originalResponse.bufferFactory();
		ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
			@Override
			public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
				if (body instanceof Flux) {
					Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
					return super.writeWith(fluxBody.map(dataBuffer -> {
						byte[] content = new byte[dataBuffer.readableByteCount()];
						dataBuffer.read(content);
						// 释放掉内存
						DataBufferUtils.release(dataBuffer);
						String rs = new String(content, Charset.forName("UTF-8"));
						if (null != list && list.size() != 0) {
							MDC.put(LogConstants.LOG_TRACE_ID, list.get(0));
						}
						rs = rs + ":APPEND";
						// 重写响应报文
						log.info("responseBody{}", rs);
						byte[] newRs = rs.getBytes(Charset.forName("UTF-8"));
						originalResponse.getHeaders().setContentLength(newRs.length);// 如果不重新设置长度则收不到消息。
						MDC.remove(LogConstants.LOG_TRACE_ID);
						return bufferFactory.wrap(newRs);
					}));
				}
				return super.writeWith(body);
			}
		};
		ServerWebExchange webExchange = exchange.mutate().request(request).response(decoratedResponse).build();
		return chain.filter(webExchange).then(
				// 异步队列
				Mono.fromRunnable(() -> {
					log.info("MessageForwardingFilterAfter{}");
				}));
	}

}
