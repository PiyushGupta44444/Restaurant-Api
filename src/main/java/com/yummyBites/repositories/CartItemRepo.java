package com.yummyBites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyBites.entities.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{

	public void deleteById(Long id);
}
