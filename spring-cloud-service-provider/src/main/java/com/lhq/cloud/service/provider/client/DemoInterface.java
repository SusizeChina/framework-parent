package com.lhq.cloud.service.provider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-cloud-service-provider")
public interface DemoInterface {
<<<<<<< HEAD
	@GetMapping("/providerDemo/serverName")
	String getServerPort();
=======
    @GetMapping("/providerDemo/serverName")
    String getServerPort();
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3
}
