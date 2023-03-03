package com.yummyBites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yummyBites.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
public void deleteCategoryByName(String name); 
public void deleteById(Long id);
public Category findCategoryByName(String name); 
public Category findCategoryById(Long id);
	

	

}
