package com.lhq.cloud.feginconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lhq.cloud.service.provider.client")
public class SpringCloudFeginConsumerApplication {

<<<<<<< HEAD
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeginConsumerApplication.class, args);
	}
=======
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeginConsumerApplication.class, args);
    }
>>>>>>> 09fdf8c5e3a78daf75eca1daba2302128adfd8d3

}
