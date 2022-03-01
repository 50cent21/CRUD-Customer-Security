package com.customer.thymeleaf.thymeleafpractice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.thymeleaf.thymeleafpractice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public List<Customer> findAllByOrderByLastNameAsc();

	public List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
