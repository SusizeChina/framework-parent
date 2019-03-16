package com.lhq.cloud.core.autoconfigure;

import org.springframework.context.annotation.Bean;

import com.lhq.cloud.core.fegin.FeginRequestInterceptor;

import feign.RequestInterceptor;

public class FeignConfiguration {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new FeginRequestInterceptor();
	}

}
