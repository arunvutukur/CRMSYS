package main.java.com.springrest.demo.dao;

import java.util.List;

import main.java.com.springrest.demo.entity.Customer;



public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
