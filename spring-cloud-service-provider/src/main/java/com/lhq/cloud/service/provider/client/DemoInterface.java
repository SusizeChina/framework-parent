package com.lhq.cloud.service.provider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-cloud-service-provider")
public interface DemoInterface {
	@GetMapping("/providerDemo/serverName")
	String getServerPort();
}
