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
@Table(name = "cart-items")
public class CartItem {

	 @Override
	public String toString() {
		return "CartItem [id=" + id + ", dish=" + dish + ", cart=" + cart + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + "]";
	}
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	 
	 @ManyToOne
	   @JoinColumn(name = "dish_id")
	  private Dish dish;
	 
	 @JsonBackReference
	 @ManyToOne
	   @JoinColumn(name = "cart_id")
	 private Cart cart;
	 
	   private int quantity;
	   @Column(name = "total_price")
	   private double totalPrice;
	   
	public CartItem() {
		super();
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
	public CartItem(Long id, Dish dish, Cart cart, int quantity, double totalPrice) {
		super();
		this.id = id;
		this.dish = dish;
		this.cart = cart;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
