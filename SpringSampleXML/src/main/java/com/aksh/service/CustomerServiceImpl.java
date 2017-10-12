package com.aksh.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aksh.model.Customer;
import com.aksh.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository; 
	
	public CustomerServiceImpl()
	{
		
	}
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		this.customerRepository= customerRepository;
	}
	
	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}


	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
}
