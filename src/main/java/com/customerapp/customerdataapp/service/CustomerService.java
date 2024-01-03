package com.customerapp.customerdataapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customerapp.customerdataapp.dao.CustomerDAO;
import com.customerapp.customerdataapp.exception.CustomerNotFoundException;
import com.customerapp.customerdataapp.model.Customer;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public Customer addCustomer(Customer customer) {
		return customerDAO.save(customer);
	}
	
	public List<Customer> getCustomers() {
		return customerDAO.findAll();
	}
	
	public Customer getCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
		if(!optionalCustomer.isPresent()) {
			throw new CustomerNotFoundException("Customer is not available...");
		}
		return optionalCustomer.get();
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
		customer.setCustomerId(customerId);
		return customerDAO.save(customer);
	}
	
	public void deleteCustomer(int customerId) {
		customerDAO.deleteById(customerId);
	}
}
