package com.aksh.repository;

import java.util.ArrayList;
import java.util.List;

import com.aksh.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.aksh.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customers= new ArrayList<>();
		Customer customer = new Customer();
		
		customer.setFirstName("Akshaya");
		customer.setLastName("Ashokan");
		
		customers.add(customer);
		
		return customers;
		
	}
}
