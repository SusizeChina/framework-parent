package com.lhq.cloud.feginconsumer.controller;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;

=======
import com.lhq.cloud.core.test.User;
import com.lhq.cloud.feginconsumer.service.DemoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhq.cloud.feginconsumer.service.DemoService;
=======
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3

@RestController
@RequestMapping("/feginconsumerDemo")
public class DemoController {
<<<<<<< HEAD
	
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
=======

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
        return applicationName + ":" + port;
    }

    @PostMapping("/user")
    @ApiOperation(value = "测试", notes = "测试", produces = "application/json")
    @ApiResponse(code = 201, message = "测试", response = String.class)
    public String getUser(@RequestBody User user) {
        log.info(user.toString());
        return user.toString();
    }
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3
}
