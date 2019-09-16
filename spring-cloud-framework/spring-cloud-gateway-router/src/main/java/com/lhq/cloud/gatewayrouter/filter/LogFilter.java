package com.lhq.cloud.gatewayrouter.filter;

import com.lhq.cloud.core.log.LogConstants;
import com.lhq.cloud.core.log.TraceLogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class LogFilter implements GlobalFilter, Ordered {
    private Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public int getOrder() {
        return -2;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String scheme = exchange.getRequest().getURI().getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme)) {
            return chain.filter(exchange);
        }
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
        final String traceId1 = traceId;
        MDC.put(LogConstants.LOG_TRACE_ID, traceId1);
        log.info("logtraceidbefore{}", traceId1);
        // 请求转发
        ServerHttpRequest request = exchange.getRequest().mutate().header(LogConstants.HTTP_HEADER_TRACE_ID, traceId)
                .build();
        ServerWebExchange webExchange = exchange.mutate().request(request).build();
        return chain.filter(webExchange).then(
                // 异步队列
                // Mono.defer(() -> {
                // MDC.put(LogConstants.LOG_TRACE_ID, traceId1);
                // ServerHttpResponse response = exchange.getResponse();
                // DataBufferFactory bufferFactory = response.bufferFactory();
                // MDC.remove(LogConstants.LOG_TRACE_ID);
                // return Mono.empty();
                // })
                // 异步队列
                Mono.fromRunnable(() -> {
                    log.info("logtraceidAfter{}", traceId1);
                    MDC.remove(LogConstants.LOG_TRACE_ID);
                }));

    }

}
