package com.customer.thymeleaf.thymeleafpractice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.thymeleaf.thymeleafpractice.dao.CustomerRepository;
import com.customer.thymeleaf.thymeleafpractice.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		
		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Customer findById(int theId) {

		Optional<Customer> result= customerRepository.findById(theId);
		
		Customer theCustomer = null;
		
		if(result.isPresent()) {
			theCustomer = result.get();
		} else {
			throw new RuntimeException("Customer with id: " + theId + " not found");
		}
		 
		return theCustomer;
		
	}

	@Override
	public void save(Customer theCustomer) {
		
        customerRepository.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		
        customerRepository.deleteById(theId);
	}

	@Override
	public List<Customer> searchBy(String theName) {
		
		List<Customer> results = null;
		
		if(theName != null && (theName.trim().length()>0)) {
			results = customerRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		return results;
	}

}
