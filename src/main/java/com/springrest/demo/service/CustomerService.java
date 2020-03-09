package main.java.com.springrest.demo.service;

import java.util.List;

import main.java.com.springrest.demo.entity.Customer;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
