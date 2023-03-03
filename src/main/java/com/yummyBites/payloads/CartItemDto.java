package com.yummyBites.payloads;

public class CartItemDto {

	public	Long customerId;
	public Long dishId;
	public CartItemDto(Long customerId, Long dishId) {
		super();
		this.customerId = customerId;
		this.dishId = dishId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getDishId() {
		return dishId;
	}
	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}
	public CartItemDto() {
		super();
	}
}
