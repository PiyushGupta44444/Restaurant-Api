package com.yummyBites.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.entities.Category;
import com.yummyBites.entities.Dish;
import com.yummyBites.payloads.DishDto;
import com.yummyBites.services.CategoryService;
import com.yummyBites.services.DishService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "restaurant-docs")
public class MenuController {
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private DishService dishService;

  @GetMapping("/menu")
  public List<Category> getMenu() {
    return this.categoryService.getCategories();
  }

  @GetMapping("/menu/{id}")
  public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
    Category category = this.categoryService.getById(id);
    return ResponseEntity.ok(category);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/menu/category")
  public ResponseEntity<Category> addCategory(@RequestBody Category category) {
    this.categoryService.addCategory(category);
    return ResponseEntity.ok(category);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/menu/category/{id}")
  public void deleteCategory(@PathVariable("id") Long id) {
    this.categoryService.deleteCategoryById(id);
  }

  @GetMapping("/menu/dish")
  public ResponseEntity<List<Dish>> getDishes() {
    List<Dish> list = this.dishService.getDishes();
    return ResponseEntity.ok(list);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/menu/dish")
  public ResponseEntity<Dish> addDish(@RequestBody DishDto dishDto) {
    Category category = this.categoryService.getById(dishDto.getCategory_id());
    Dish dish = new Dish();
    dish.setId(dishDto.getId());
    dish.setName(dishDto.getName());
    dish.setPrice(dishDto.getPrice());
    dish.setCategory(category);
    this.dishService.addDish(dish);
    return ResponseEntity.ok(dish);
  }
@PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/menu/dish/{id}")
  public void deleteDish(@PathVariable("id") Long id) {
    this.dishService.deleteById(id);
  }

@PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/menu/dish/{id}")
  public ResponseEntity<Dish> updateDish(@RequestBody DishDto dishDto, @PathVariable("id") Long id) {
    Dish dish = dishService.getDishById(id);
    if (dish != null) {
      Category category = this.categoryService.getById(dishDto.getCategory_id());
      dish.setName(dishDto.getName());
      dish.setPrice(dishDto.getPrice());
      dish.setCategory(category);
      dishService.addDish(dish);
    }
    return ResponseEntity.ok(dish);
  }

}
