package com.aksh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aksh.model.Customer;
import com.aksh.repository.CustomerRepository;
//import com.aksh.repository.HibernateCustomerRepositoryImpl;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	//@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		System.out.println("Constructor injection");
		this.customerRepository = customerRepository;
	}
	
	//@Autowired

	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("setter injection");
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}
}
