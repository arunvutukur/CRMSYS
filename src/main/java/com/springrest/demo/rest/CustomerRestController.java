package main.java.com.springrest.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.springrest.demo.entity.Customer;
import main.java.com.springrest.demo.service.CustomerService;
import main.utilities.CustomerNotFoundException;

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
	  
			Customer theCustomer = customerService.getCustomer(customerId);
			
			if (theCustomer == null) {
				throw new CustomerNotFoundException("Customer id not found - " + customerId);
			}
			
			return theCustomer;
	  }	 
	  
	  
	//Post Mapping for add new customer
	  @PostMapping("/customers")
	  public Customer addCustomer(@RequestBody Customer theCustomer) {
		  
		   //Also just in case the pass an id in JSON ....set id to 0
		   //this is way to save of new item ..instead of using update
		  
		   theCustomer.setId(0);
		  	
		   customerService.saveCustomer(theCustomer);
		   
		   return theCustomer;
	  }
	  
	  //Put Mapping for update a customer
	  @PutMapping("/customers")
	  public Customer updateCustomer(@RequestBody Customer theCustomer) {		  
	  	
		   customerService.saveCustomer(theCustomer);		   
		   return theCustomer;
	  }
	//use customer here and check what would be the output
	/*
	 * 
	 * @PutMapping("/customer") public Customer updateCustomer(@RequestBody
	 * Customer theCustomer) {
	 * 
	 * customerService.saveCustomer(theCustomer); return theCustomer; }
	 */
	  
	  
	  
	  
	  
}
