package com.yummyBites.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import com.yummyBites.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// @Query("select c from customers c where c.email = : email")
	// public Customer getCustomerByEmail(@Param("email") String email);

	public Customer findByEmail(String email);

	public Optional<Customer> findCustomerByEmail(String email);

}
