package com.sandbox.springdemo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sandbox.springdemo.controller.CustomerNotFoundException;
import com.sandbox.springdemo.entity.Customer;

@Service
public class CustomerRestClientService implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${crm.rest.base.uri}")
	private String baseURI;
	
	@Override
	public List<Customer> getCustomers(String searchTerm, String sortBy, int pageNo, int pageSize) {
		UriComponentsBuilder theBuilder = UriComponentsBuilder.fromHttpUrl(baseURI)
															.queryParam("pageNo", pageNo)
															.queryParam("pageSize", pageSize)
															.queryParam("searchTerm", searchTerm)
															.queryParam("sortBy", sortBy);
		ResponseEntity<Customer[]> response = restTemplate.getForEntity(theBuilder.toUriString(),Customer[].class);
		
		if(response.getStatusCode()==HttpStatus.NOT_FOUND)
			throw new CustomerNotFoundException("Customer not found");
		
		return Arrays.asList(response.getBody());
	}
	
	@Override
	public List<Customer> getCustomers(int pageNo, int pageSize) {
		UriComponentsBuilder theBuilder = UriComponentsBuilder.fromHttpUrl(baseURI)
						.queryParam("pageNo", pageNo)
						.queryParam("pageSize", pageSize);
		ResponseEntity<Customer[]> response = restTemplate.getForEntity(theBuilder.toUriString(),Customer[].class);
		
		if(response.getStatusCode()==HttpStatus.NOT_FOUND)
			throw new CustomerNotFoundException("Customer not found");
		
		return Arrays.asList(response.getBody());
	}
	
	@Override
	public Customer getCustomer(int theId) {
		ResponseEntity<Customer> response = restTemplate.getForEntity(baseURI+"/"+theId,Customer.class);
		
		if(response.getStatusCode()==HttpStatus.NOT_FOUND)
			throw new CustomerNotFoundException("Customer not found");
		
		return response.getBody();
	}
	
	@Override
	public void addCustomer(Customer theCustomer) {
		if (theCustomer.getId()==0)
			restTemplate.postForEntity(baseURI, theCustomer, String.class);
		else
			restTemplate.put(baseURI, theCustomer);
	}


	@Override
	public void deleteCustomer(int theId) {
		restTemplate.delete(baseURI+"/"+theId);
	}

	@Override
	public long countCustomers() {
		ResponseEntity<Long> response = restTemplate.getForEntity(baseURI+"/count",Long.class);
		
		if(response.getStatusCode()==HttpStatus.NOT_FOUND)
			throw new CustomerNotFoundException("Customer not found");
		
		return response.getBody();
	}

	@Override
	public long countCustomers(String searchTerm) {
		UriComponentsBuilder theBuilder = UriComponentsBuilder.fromHttpUrl(baseURI+"/count")
															.queryParam("searchTerm", searchTerm);
		ResponseEntity<Long> response = restTemplate.getForEntity(theBuilder.toUriString(),Long.class);
		
		if(response.getStatusCode()==HttpStatus.NOT_FOUND)
			throw new CustomerNotFoundException("Customer not found");
		
		return response.getBody();
	}
	
}
