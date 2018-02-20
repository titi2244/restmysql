package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;

@Controller
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping("/hello")
	public @ResponseBody Customer hello() {
		Customer customer = new Customer(10, "sunny", "park", "sunny@boot.com");
		return customer;
	}

	@RequestMapping("/sayHello")
	public String sayHello(Model model) {
		//Customer customer = new Customer(10, "sunny", "park", "sunny@boot.com");
		model.addAttribute("greetMessage", "Hello World!");
		return "customer/sayHello";
	}

}
