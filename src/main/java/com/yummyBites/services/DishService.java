package com.yummyBites.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yummyBites.entities.Dish;
import com.yummyBites.payloads.DishDto;
import com.yummyBites.repositories.DishRepository;

@Component
public class DishService {

	@Autowired
	private DishRepository dishRepository;
	
	public Dish getDishByName(String name) {
	    Dish dish=this.dishRepository.findByName(name);
		return dish;
	}
	public Dish getDishById(Long id) {
	    Dish dish=this.dishRepository.findDishById(id);
		return dish;
	}
	
	
	
	public List<Dish> getDishes() {
		List<Dish> list=this.dishRepository.findAll();
		return list;
	}
	public Dish addDish(Dish dish) {
	      Dish dish2=this.dishRepository.save(dish);
	      return dish2;
	}
	public void deleteById(Long id) {
		this.dishRepository.deleteById(id);
	}
	public void updateById(DishDto dishDto,Long id) {
		dishDto.setId(id);
	    this.dishRepository.save(dishDto);
	}
		
	
}
