package com.aksh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.aksh.model.Customer;
import com.aksh.repository.CustomerRepository;
import com.aksh.repository.HibernateCustomerRepositoryImpl;

@Service("customerService")
@Scope("prototype")
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	public CustomerServiceImpl()
	{
		
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		System.out.println("using Constructor injection");
		this.customerRepository = customerRepository;
	}
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("using setter injection");
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll()
	{
		return customerRepository.findAll();
	}
}
