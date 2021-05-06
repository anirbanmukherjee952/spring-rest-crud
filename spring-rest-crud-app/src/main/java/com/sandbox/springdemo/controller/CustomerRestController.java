package com.sandbox.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.springdemo.entity.Customer;
import com.sandbox.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(@RequestParam int pageNo,
										@RequestParam int pageSize,
										@RequestParam(required=false) String searchTerm,
										@RequestParam(required=false) String sortBy){
		searchTerm = (searchTerm==null)? "" : searchTerm;
		sortBy = (sortBy==null)? "lastName" : sortBy;
		List<Customer> customerList = customerService.getCustomers(searchTerm, sortBy, pageNo, pageSize);
		
		if (customerList.isEmpty())
			throw new CustomerNotFoundException("Customer not found");
		
		return customerList;
	}
	
	@GetMapping("/customers/count")
	public Integer countCustomers(@RequestParam(required=false) String searchTerm){
		searchTerm = (searchTerm==null)? "" : searchTerm;
		int count = (int) customerService.countCustomers(searchTerm);
		return count;
	}
	
	@GetMapping("/customers/{theId}")
	public Customer getCustomer(@PathVariable int theId) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		if (theCustomer==null)
			throw new CustomerNotFoundException("Customer ID not found: " + theId);
		
		return theCustomer;
	
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.addCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.addCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{theId}")
	public Integer deleteCustomer(@PathVariable int theId) {
		
		if (customerService.getCustomer(theId)==null)
			throw new CustomerNotFoundException("Customer ID not found: " + theId);
		
		customerService.deleteCustomer(theId);
		return theId;
	
	}
	
}
























