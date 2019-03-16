package com.lhq.cloud.feginconsumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.cloud.feginconsumer.service.DemoService;

@RestController
@RequestMapping("/feginconsumerDemo")
public class DemoController {
	
	private Logger log = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	DemoService demonService;
	
	@Value("${id}")
	private String id;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String applicationName;
	
    @Autowired
    public HttpServletRequest request;
	@GetMapping("/feginTest")
	@ResponseBody
	public String feginTest() {
		String header = request.getHeader("X-Request-Id");
		log.info("X-Request-Id{}", header);
		String header1 = request.getHeader("X-Request-Foo");
		log.info("X-Request-Foo{}", header1);
		return demonService.feginTest();
	}

	@GetMapping("/testConfig")
	@ResponseBody
	public String getConfig() {
		return id;
	}
	
	@GetMapping("/serverName")
	@ResponseBody
	public String getServerPort() {
		return applicationName+":"+port;
	}
}
