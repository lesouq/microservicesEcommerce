package com.thelem.microservice.oauth2.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class OAuth2Config extends GlobalAuthenticationConfigurerAdapter{

	 @Override
	    public void init(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("thelem")
	                .password(passwordEncoder().encode("thelem"))
	                .roles("ADMIN");
	    }
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
