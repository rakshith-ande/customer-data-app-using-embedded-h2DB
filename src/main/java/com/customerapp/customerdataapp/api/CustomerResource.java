package com.customerapp.customerdataapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.customerdataapp.model.Customer;
import com.customerapp.customerdataapp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
		return customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
	}

}
