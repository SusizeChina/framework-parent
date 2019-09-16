package com.lhq.cloud.core.log;

import javax.annotation.PostConstruct;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

public class TraceLogUtils {

	@Value("${spring.application.name}")
	private String applicationName;

	private static String appName;

	@PostConstruct
	public void init() {
		appName = applicationName;
	}

	public static String getTraceId() {
		String traceId = MDC.get("traceId");
		
		return appName + ":" + traceId;
	}

}
