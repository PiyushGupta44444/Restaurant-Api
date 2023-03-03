package com.yummyBites.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yummyBites.security.*;
import com.yummyBites.entities.Customer;
import com.yummyBites.repositories.CustomerRepository;
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Customer customer=this.customerRepository.findByEmail(username);
		if(customer==null) {
			throw new UsernameNotFoundException(" UserDetailServiceImpl mein dikkat hai no user");
		}
		CustomUserDetail customUserDetail=new CustomUserDetail(customer);
		return customUserDetail;
	}

}
