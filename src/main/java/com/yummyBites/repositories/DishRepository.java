package com.yummyBites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyBites.entities.Dish;
import com.yummyBites.payloads.DishDto;

public interface DishRepository extends JpaRepository<Dish, Long> {

	public Dish findDishById(Long id);
	public Dish findByName(String name);
	public void save(DishDto dishDto);
	
	
}
