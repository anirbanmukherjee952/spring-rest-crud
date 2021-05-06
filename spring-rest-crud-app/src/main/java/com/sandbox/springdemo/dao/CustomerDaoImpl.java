package com.sandbox.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sandbox.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int pageNo, int pageSize) {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		theQuery.setFirstResult(pageNo*pageSize);
		theQuery.setMaxResults(pageSize);
		
		// execute query and fetch result
		List<Customer> customerList = theQuery.getResultList();
		
		return customerList;
		
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer where id=:theId",Customer.class);
		theQuery.setParameter("theId", theId);
		
		// execute query and fetch result
		Customer theCustomer = theQuery.uniqueResult();
		
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {

		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update customer
		Customer theCustomer = currentSession.get(Customer.class,theId);
		currentSession.delete(theCustomer);
		
	}

	@Override
	public List<Customer> getCustomers(String searchTerm, String sortBy, int pageNo, int pageSize) {

		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Customer> theQuery = null;
		
		if (searchTerm.trim().length() == 0) {
			theQuery = currentSession.createQuery("from Customer order by "+sortBy,Customer.class);	
			theQuery.setFirstResult(pageNo*pageSize);
			theQuery.setMaxResults(pageSize);
		}
		else {
			theQuery = currentSession.createQuery("from Customer where "
												+ "lower(firstName) like :theName or lower(lastName) like :theName "
												+ "order by "+sortBy,Customer.class);
			theQuery.setParameter("theName", "%"+searchTerm.toLowerCase()+"%");
			theQuery.setFirstResult(pageNo*pageSize);
			theQuery.setMaxResults(pageSize);
		}
		
		
		// execute query and fetch result
		List<Customer> customerList = theQuery.getResultList();
		
		return customerList;
		
	}

	@Override
	public long countCustomers() {
		
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
	
		// create query
		Query<Long> theQuery = currentSession.createQuery("Select count(*) from Customer",Long.class);
		
		// execute query
		long count = theQuery.uniqueResult();
		
		return count;
	
	}

	@Override
	public long countCustomers(String searchTerm) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
	
		// create query
		Query<Long> theQuery = currentSession.createQuery("Select count(*) from Customer where "
														+ "lower(firstName) like :theName or lower(lastName) like :theName",Long.class);
		theQuery.setParameter("theName", "%"+searchTerm.toLowerCase()+"%");
		
		// execute query
		long count = theQuery.uniqueResult();
		
		return count;
	}
	
}










