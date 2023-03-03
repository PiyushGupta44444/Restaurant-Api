package com.yummyBites.entities;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(name = "customer_id")
	 private Long customerId;
	 
	 @JsonManagedReference
	 @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	 private List<OrderItem> orderItems;
	 
	 @Column(name = "total_price")
	 private double totalPrice;
	 
	 @Column(name = "order_date")
	 private Date date;
	 
	 private String address;
	 
	 
	 
	 public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customer_id) {
		this.customerId = customer_id;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Order() {
		super();
	}
	public Order(Long id, Long customerId, List<OrderItem> orderItems, double totalPrice) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderItems = orderItems;
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	  public Order() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
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
//	public Order(Long id, Customer customer, List<Dish> dishes, Map<Dish, Integer> quantities) {
//		super();
//		this.id = id;
//		this.customer = customer;
//		this.dishes = dishes;
//		this.quantities = quantities;
//	}
//
//	@Id
//	  @GeneratedValue(strategy = GenerationType.IDENTITY)
//	  private Long id;
//
//	  @ManyToOne
//	  @JoinColumn(name = "customer_id")
//	  private Customer customer;
//
//	  @ManyToMany
//	  @JoinTable(
//	    name = "order_dishes",
//	    joinColumns = @JoinColumn(name = "order_id"),
//	    inverseJoinColumns = @JoinColumn(name = "dish_id")
//	  )
//	  private List<Dish> dishes;
//
//	  @ElementCollection
//	  @CollectionTable(
//	    name = "order_quantities",
//	    joinColumns = @JoinColumn(name = "order_id")
//	  )
//	  @MapKeyJoinColumn(name = "dish_id")
//	  @Column(name = "quantity")
//	  private Map<Dish, Integer> quantities;
//	  
//	  private Date date;
//	  private double total;
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public double getTotal() {
//		return total;
//	}
//
//	public void setTotal(double total) {
//		this.total = total;
//	}
//


	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String description;
//	private LocalDate order_date;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "customer_id",referencedColumnName = "id")
//	private Customer customer;
//	
//	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Cart.class)
//	@JoinColumn(name = "order_id",referencedColumnName = "id")
//	private List<Cart> cartItems;
//
//	public Order() {
//		super();
//	}
//	public Long getId() {
//		return id;
//	}
//
//	public Order(Long id, String description, LocalDate order_date, Customer customer, List<Cart> cartItems) {
//		super();
//		this.id = id;
//		this.description = description;
//		this.order_date = order_date;
//		this.customer = customer;
//		this.cartItems = cartItems;
//	}
//	public LocalDate getOrder_date() {
//		return order_date;
//	}
//	public void setOrder_date(LocalDate order_date) {
//		this.order_date = order_date;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
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
//	public List<Cart> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(List<Cart> cartItems) {
//		this.cartItems = cartItems;
//	}
}
