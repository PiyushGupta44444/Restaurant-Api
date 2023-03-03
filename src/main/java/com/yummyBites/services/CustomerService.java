package com.yummyBites.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yummyBites.entities.Customer;
import com.yummyBites.repositories.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		this.customerRepository.save(customer);
		return customer;
	}
	public Customer getCustomerByEmail(String email) {
		Customer customer=  this.customerRepository.findByEmail(email);
		return customer;
	}
	public Optional<Customer> findCustomerByEmail(String email){
		Optional<Customer> customer=this.customerRepository.findCustomerByEmail(email);
		return customer;
	}
	public List<Customer> getAllCustomers() {
	List<Customer> list=this.customerRepository.findAll();
	return list;
	}  
	public void updateCustomer(Customer customer,String email) {
		customer.setEmail(email);
		this.customerRepository.save(customer);
	}
}
