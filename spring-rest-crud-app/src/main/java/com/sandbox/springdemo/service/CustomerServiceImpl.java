package com.sandbox.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.springdemo.dao.CustomerDao;
import com.sandbox.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int pageNo, int pageSize) {
		return customerDao.getCustomers(pageNo, pageSize);
	}
	
	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		customerDao.addCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDao.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers(String searchTerm, String sortBy, int pageNo, int pageSize) {
		return customerDao.getCustomers(searchTerm,sortBy,pageNo,pageSize);
	}

	@Override
	@Transactional
	public long countCustomers() {
		return customerDao.countCustomers();
	}

	@Override
	@Transactional
	public long countCustomers(String searchTerm) {
		return customerDao.countCustomers(searchTerm);
	}
	
}
