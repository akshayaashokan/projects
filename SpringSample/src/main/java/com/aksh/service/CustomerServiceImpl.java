package com.aksh.service;

import java.util.List;

import com.aksh.model.Customer;
import com.aksh.repository.CustomerRepository;
import com.aksh.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.aksh.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}
}
