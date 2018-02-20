package com.example.service;

import java.util.List;
import java.util.Optional;

//import org.rvslab.chapter2.domain.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
//	MessageSender sender;

	public List<Customer> findAll() {
        return customerRepository.findAllOrderByName();
    }

    public Customer findOne(Integer id) {
        return customerRepository.findOne(id);
    }

    public Customer create(Customer customer) {
        //return customerRepository.save(customer);
    	Optional<Customer> existingCustomer = customerRepository.findByFirstName(customer.getFirstName());
		if (existingCustomer.isPresent()){
			throw new RuntimeException("is already exists");
		} else {
			customerRepository.save(customer); 
			//sender.send(customer.getEmail());
		} 
		return customer;
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.delete(id);
    }
    
    public void setEmailIfAny(Integer id) {
        Customer customer = customerRepository.findOne(id);
        if(customer.getEmail() == null || customer.getEmail().isEmpty()) {
        	customer.setEmail(customer.getFirstName() + "@boot.com");
        }
    }    
  
  /*
    public Customer register(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findByFirstName(customer.getFirstName());
		if (existingCustomer.isPresent()){
			throw new RuntimeException("is already exists");
		} else {
			customerRepository.save(customer); 
			//sender.send(customer.getEmail());
		} 
   	return customer;
    }
*/
}
