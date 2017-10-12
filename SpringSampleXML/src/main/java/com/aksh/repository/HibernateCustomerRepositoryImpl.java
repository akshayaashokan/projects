package com.aksh.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.aksh.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	@Value("${dbUsername}")
	private String dbUsername;
	



	@Override
	public List<Customer> findAll(){
		System.out.println(dbUsername);
		List<Customer> customers= new ArrayList<>();
		Customer customer = new Customer();
		
		customer.setFirstName("Akshaya");
		customer.setLastName("Ashokan");
		
		customers.add(customer);
		
		return customers;
		
	}
}
