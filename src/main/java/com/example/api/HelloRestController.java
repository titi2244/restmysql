package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);
	
	@Autowired
	Environment env;
	
	@RequestMapping("/")
	public String welcome() {
		return "Hello Spring Boot. Try  http://{localhost:8001}/customers";
	}
	
	@RequestMapping("/api/sayHello")
	public String index() {
		return "Hello Spring Boot";
	}
	
	@RequestMapping("/api/customProperties")
	public String customProps() {
		String message = env.getProperty("bootrest.customproperty");
		return message;
	}

	@RequestMapping("/makeLog")
	public String makeLog() {
		String message = env.getProperty("bootrest.customproperty");
		logger.info("bootrest.customproperty : " + message);
		return "OK";
	}
	
}
