package com.yummyBites.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "carts")
public class Cart {
	@Id
	 private Long id;
	 private Long customer_id;
	 @JsonManagedReference
	 @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
     private List<CartItem> cartItems;
	 private double totalPrice;
	 private double discountedTotal;
	 private String promocode;
	 
	 
	 
	public double getDiscountedTotal() {
		return discountedTotal;
	}
	public void setDiscountedTotal(double discountedTotal) {
		this.discountedTotal = discountedTotal;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Cart(Long id, Long customer_id, List<CartItem> cartItems, double totalPrice) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}
	public Cart() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	 @Id
//	  @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  private Long id;
//
//	  @ManyToOne
//	  @JoinColumn(name = "customer_id")
//	  private Customer customer;
//
//	  @ManyToMany
//	  @JoinTable(
//	    name = "cart_dishes",
//	    joinColumns = @JoinColumn(name = "cart_id"),
//	    inverseJoinColumns = @JoinColumn(name = "dish_id")
//	  )
//	  private List<Dish> dishes;
//
//	  @ElementCollection
//	  @CollectionTable(
//	    name = "cart_quantities",
//	    joinColumns = @JoinColumn(name = "cart_id")
//	  )
//	  @MapKeyJoinColumn(name = "dish_id")
//	  @Column(name = "quantity")
//	  private Map<Dish, Integer> quantities;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public List<Dish> getDishes() {
//		return dishes;
//	}
//
//	public void setDishes(List<Dish> dishes) {
//		this.dishes = dishes;
//	}
//
//	public Map<Dish, Integer> getQuantities() {
//		return quantities;
//	}
//
//	public void setQuantities(Map<Dish, Integer> quantities) {
//		this.quantities = quantities;
//	}
//
//	public Cart() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Cart(Long id, Customer customer, List<Dish> dishes, Map<Dish, Integer> quantities) {
//		super();
//		this.id = id;
//		this.customer = customer;
//		this.dishes = dishes;
//		this.quantities = quantities;
//	}
//	
	
	
	
	
	
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private Long dish_id;
//	private String dish_name;
//	private int quantity;
//	private float amount=dish_id*quantity;
//	
//	
//	
//	public Cart() {
//		super();
//	}
//	public Cart(Long id, Long dish_id, String dish_name, float amount,int quantity) {
//		super();
//		this.id = id;
//		this.dish_id = dish_id;
//		this.dish_name = dish_name;
//		this.amount =dish_id*quantity ;
//		this.quantity = quantity;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public Long getDish_id() {
//		return dish_id;
//	}
//	public void setDish_id(Long dish_id) {
//		this.dish_id = dish_id;
//	}
//	public String getDish_name() {
//		return dish_name;
//	}
//	public void setDish_name(String dish_name) {
//		this.dish_name = dish_name;
//	}
//	public float getAmount() {
//		return amount;
//	}
//	public void setAmount(float amount) {
//		this.amount = amount;
//	}
	
}
