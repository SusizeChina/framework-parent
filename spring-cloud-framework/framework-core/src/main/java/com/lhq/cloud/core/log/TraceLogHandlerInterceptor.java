package com.lhq.cloud.core.log;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TraceLogHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String traceId = request.getHeader(LogConstants.HTTP_HEADER_TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            traceId = TraceLogUtils.getTraceId();
        }
        MDC.put(LogConstants.LOG_TRACE_ID, traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        MDC.remove(LogConstants.LOG_TRACE_ID);
    }
}
