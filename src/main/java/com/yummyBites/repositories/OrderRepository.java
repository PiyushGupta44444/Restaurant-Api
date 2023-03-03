package com.yummyBites.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyBites.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

//	public Optional<Order> findById(Long id);
	public List<Order> findByCustomerId(Long id);
}
