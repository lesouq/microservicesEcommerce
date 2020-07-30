package com.thelem.microservice.oauth2.server;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
@EnableResourceServer
//@EnableJdbcHttpSession
@RestController
public class Oauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ServerApplication.class, args);
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().url("jdbc:mysql://192.168.99.100:33306/oauth2?useSSL=false")
				.username("default").password("default").driverClassName("com.mysql.jdbc.Driver").build();
	}
}
