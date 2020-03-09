package main.java.com.springrest.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.springrest.demo.entity.Customer;
import main.java.com.springrest.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//Auto wire the customer Service
	@Autowired
	private CustomerService customerService;
	
	//Add Mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	//Add Mapping for GET/customer{id}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId){
		
		return customerService.getCustomer(customerId);
	}
	
}
