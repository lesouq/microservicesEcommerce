package com.thelem.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableAdminServer
public class ServerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerEurekaApplication.class, args);
	}

}
