package com.lhq.cloud.core.fegin;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lhq.cloud.core.autoconfigure.FeignConfiguration;
import com.lhq.cloud.core.log.LogConstants;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeginRequestInterceptor implements RequestInterceptor {
	
	private Logger logger = LoggerFactory.getLogger(FeignConfiguration.class);

	@Override
	public void apply(RequestTemplate requestTemplate) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				String values = request.getHeader(name);
				requestTemplate.header(name, values);
			}
		}
		 String traceId = MDC.get(LogConstants.LOG_TRACE_ID);
         if (!StringUtils.isEmpty(traceId)) {
        	 requestTemplate.header(LogConstants.HTTP_HEADER_TRACE_ID, traceId);
         }
		Enumeration<String> bodyNames = request.getParameterNames();
		StringBuffer body = new StringBuffer();
		if (bodyNames != null) {
			while (bodyNames.hasMoreElements()) {
				String name = bodyNames.nextElement();
				String values = request.getParameter(name);
				body.append(name).append("=").append(values).append("&");
			}
		}
		if (body.length() != 0) {
			body.deleteCharAt(body.length() - 1);
			requestTemplate.body(body.toString());
			logger.info("feign interceptor body:{}", body.toString());
		}
	}
}
