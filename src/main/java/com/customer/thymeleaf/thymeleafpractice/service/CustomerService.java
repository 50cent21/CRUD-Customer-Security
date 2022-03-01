package com.customer.thymeleaf.thymeleafpractice.service;

import java.util.List;

import com.customer.thymeleaf.thymeleafpractice.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
	
	public List<Customer> searchBy(String theName);

}
