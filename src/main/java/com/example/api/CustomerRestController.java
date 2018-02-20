package com.example.api;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerServie;
	
	@RequestMapping(method = RequestMethod.GET)
	List<Customer> getCustomers() { 
		List<Customer> customers = customerServie.findAll();
		return customers;
	}
	
	@RequestMapping("map")
	Map<Integer, Customer> getCustomerMap() {
		Map<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
		
		List<Customer> customers = customerServie.findAll();
		customers.forEach((customer)->{
			customerServie.setEmailIfAny(customer.getId());
			customerMap.put(customer.getId(), customer);
			});
		return customerMap;
	}

	@RequestMapping("setAllCustomersEmailIfAny")
	Map<Integer, Customer> setAllCustomersEmailIfAny() {
		Map<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
		List<Customer> customers = customerServie.findAll();
		customers.forEach((customer)->{
			customerServie.setEmailIfAny(customer.getId());
			customerMap.put(customer.getId(), customer);
			});
		return customerMap;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerServie.findOne(id);
		return customer;
	}
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Customer> postCustomer(@RequestBody Customer customer, UriComponentsBuilder uriBuilder){
		Customer created = customerServie.create(customer);
		URI location = uriBuilder.path("api/customer/{id}").buildAndExpand(created.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
	}
	*/
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomer(@RequestBody Customer customer) {
		return customerServie.create(customer);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerServie.update(customer);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerServie.delete(id);
	}

}
