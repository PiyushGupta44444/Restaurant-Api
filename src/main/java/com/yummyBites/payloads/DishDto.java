package com.yummyBites.payloads;

public class DishDto {

	  private Long id;
	  private String name;
	  private double price;
	  private Long category_id;
	  
	public DishDto() {
		super();
	}
	public DishDto(Long id, String name, double price, Long category_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category_id = category_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	  
}
