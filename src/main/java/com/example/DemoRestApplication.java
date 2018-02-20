package com.example;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@EnableGlobalMethodSecurity
//@EnableResourceServer
//@EnableAuthorizationServer
@SpringBootApplication

public class DemoRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
	  	
     	//System.out.println("........Hello........");
		SpringApplication.run(DemoRestApplication.class, args);
     	//System.out.println("........World!........");
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoRestApplication.class);
    }
}
