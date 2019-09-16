package com.lhq.cloud.service.provider.controller;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;

=======
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
@RestController
@RequestMapping("/providerDemo")
public class ProviderController {
	
	private Logger log = LoggerFactory.getLogger(ProviderController.class);
	
	@Value("${id}")
	private String id;

	@Value("${server.port}")
	private String port;

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping("/testConfig")
	@ResponseBody
	public String getGitTestConfig() {
		log.info("logger{}", "log demo!!!!!!!!");
		return id;
	}

	@Autowired
	public HttpServletRequest request;

	@GetMapping("/serverName")
	@ResponseBody
	public String getServerPort() {
		String header = request.getHeader("X-Request-Id");
		log.info("X-Request-Id{}", header);
		String header1 = request.getHeader("X-Request-Foo");
		log.info("X-Request-Foo{}", header1);
		return applicationName + ":" + port;
	}
=======
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/providerDemo")
public class ProviderController {

    private Logger log = LoggerFactory.getLogger(ProviderController.class);

    @Value("${id}")
    private String id;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/testConfig")
    @ResponseBody
    public String getGitTestConfig() {
        log.info("logger{}", "log demo!!!!!!!!");
        return id;
    }

    @Autowired
    public HttpServletRequest request;

    @GetMapping("/serverName")
    @ResponseBody
    public String getServerPort() {
        String header = request.getHeader("X-Request-Id");
        log.info("X-Request-Id{}", header);
        String header1 = request.getHeader("X-Request-Foo");
        log.info("X-Request-Foo{}", header1);
        return applicationName + ":" + port;
    }
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3
}
