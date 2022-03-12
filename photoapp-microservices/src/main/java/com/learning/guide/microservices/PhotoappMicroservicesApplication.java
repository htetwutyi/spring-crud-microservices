package com.learning.guide.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoappMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappMicroservicesApplication.class, args);
	}

}
