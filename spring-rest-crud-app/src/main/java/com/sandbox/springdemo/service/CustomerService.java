package com.sandbox.springdemo.service;

import java.util.List;

import com.sandbox.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers(int pageNo, int pageSize);
	
	public List<Customer> getCustomers(String searchTerm, String sortBy, int pageNo, int pageSize);
		
	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public long countCustomers();

	public long countCustomers(String searchTerm);

}
