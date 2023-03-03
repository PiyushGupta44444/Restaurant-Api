package com.yummyBites.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yummyBites.entities.Category;
// import com.yummyBites.payloads.DishDto;
import com.yummyBites.repositories.CategoryRepository;

@Component
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		Category category2 = categoryRepository.save(category);
		return category2;
	}

	public void deleteCategoryByName(String name) {
		this.categoryRepository.deleteCategoryByName(name);
	}

	public void deleteCategoryById(Long id) {
		this.categoryRepository.deleteById(id);
	}

	public Category getCategoryByName(String name) {
		Category category = this.categoryRepository.findCategoryByName(name);
		return category;
	}

	public Category getById(Long id) {
		Category category = this.categoryRepository.findCategoryById(id);
		return category;
	}

	public List<Category> getCategories() {
		List<Category> list = (List<Category>) this.categoryRepository.findAll();
		return list;
	}

	public void updateCategory(Category category, Long id) {
		category.setId(id);
		this.categoryRepository.save(category);
	}
}
