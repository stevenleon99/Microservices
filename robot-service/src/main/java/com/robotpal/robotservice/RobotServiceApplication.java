package com.robotpal.robotservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RobotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotServiceApplication.class, args);
	}

}
