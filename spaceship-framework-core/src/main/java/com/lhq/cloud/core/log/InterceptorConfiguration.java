package com.lhq.cloud.core.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private TraceLogHandlerInterceptor traceLogHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(traceLogHandlerInterceptor);
		addInterceptor.addPathPatterns("/**");
	}

}
