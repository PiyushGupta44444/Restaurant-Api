package com.yummyBites.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyBites.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

//	public List<Cart> findByCustomer(Customer customer);
	 public Cart findUserById(Long customer_id);
}
