package com.yummyBites.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	 
	 @ManyToOne
	   @JoinColumn(name = "dish_id")
	 private Dish dish;
	 
	@JsonBackReference
	@ManyToOne
	   @JoinColumn(name = "order_id")
	 private Order order;
	 
	   private int quantity;
	   @Column(name = "total_price")
	   private double totalPrice;
	   
	   
	   
	   public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		
	public OrderItem() {
		super();
	}
	
	public OrderItem(Long id, Dish dish, Order order, int quantity, double totalPrice) {
		super();
		this.id = id;
		this.dish = dish;
		this.order = order;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
