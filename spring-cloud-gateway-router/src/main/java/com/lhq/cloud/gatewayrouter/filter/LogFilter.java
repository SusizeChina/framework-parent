package com.lhq.cloud.gatewayrouter.filter;

import java.util.List;

import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import com.lhq.cloud.core.log.LogConstants;
import com.lhq.cloud.core.log.TraceLogUtils;

import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		List<String> list = exchange.getRequest().getHeaders().get(LogConstants.HTTP_HEADER_TRACE_ID);
		String traceId = "";
		if (list == null || list.size() == 0) {
			traceId = TraceLogUtils.getTraceId();
		} else {
			traceId = list.get(0);
			if (StringUtils.isEmpty(traceId)) {
				traceId = TraceLogUtils.getTraceId();
			}
		}
		MDC.put(LogConstants.LOG_TRACE_ID, traceId);
		ServerHttpRequest request = exchange.getRequest().mutate().header(LogConstants.HTTP_HEADER_TRACE_ID, traceId)
				.build();
		ServerWebExchange webExchange = exchange.mutate().request(request).build();
		return chain.filter(webExchange);
	}

}
