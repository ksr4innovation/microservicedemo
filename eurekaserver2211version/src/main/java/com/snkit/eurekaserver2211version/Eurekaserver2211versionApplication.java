package com.snkit.eurekaserver2211version;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver2211versionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaserver2211versionApplication.class, args);
	}

}
