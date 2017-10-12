package com.aksh.repository;

import java.util.List;

import com.aksh.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}