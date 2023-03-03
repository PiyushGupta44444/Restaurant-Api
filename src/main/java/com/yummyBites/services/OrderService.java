package com.yummyBites.services;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyBites.entities.Cart;
import com.yummyBites.entities.CartItem;
import com.yummyBites.entities.Order;
import com.yummyBites.entities.OrderItem;
import com.yummyBites.payloads.OrderDto;
import com.yummyBites.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired 
	private CartService cartService;
	
	public void saveOrder(Order order) {
		this.orderRepository.save(order);
	}
	
//	public Order createOrder(Long customer_id, Cart cart) {
//	      Order order = new Order();
//	      order.setCustomer_id(customer_id);
//	      order.setOrderItems(new ArrayList<>());
//
//	      List<CartItem> cartItems = cart.getCartItems();
//	      for (CartItem cartItem : cartItems) {
//	          OrderItem orderItem = new OrderItem();
//	          orderItem.setDish(cartItem.getDish());
//	          orderItem.setQuantity(cartItem.getQuantity());
//	          orderItem.setOrder(order);
//	          orderItem.setTotalPrice(cartItem.getTotalPrice());
//	          order.getOrderItems().add(orderItem);
//	       }
//	      double totalPrice = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
//	      order.setTotalPrice(totalPrice);
//
//	      Order savedOrder =this.orderRepository.save(order);
//	      return savedOrder;
//	}
	
	public String placeOrder(OrderDto orderDto) {
		 Cart cart = this.cartService.getCart(orderDto.getCustomerId());
		 if(cart.getTotalPrice()<=0) {
			 return "your cart is empty";
		 }
		  Order order = new Order();
		  order.setCustomerId(cart.getCustomer_id());
		  order.setDate(new Date());
		  order.setAddress(orderDto.getAddress());
		  order.setTotalPrice(cart.getDiscountedTotal());
		  order.setOrderItems(new ArrayList<>());
		  List<CartItem> cartItems = cart.getCartItems();
	      for (CartItem cartItem : cartItems) {
	          OrderItem orderItem = new OrderItem();
	          orderItem.setDish(cartItem.getDish());
	          orderItem.setQuantity(cartItem.getQuantity());
	          orderItem.setOrder(order);
	          orderItem.setTotalPrice(cartItem.getTotalPrice());
	          order.getOrderItems().add(orderItem);
	       }
		  saveOrder(order);
		  this.cartService.clearCart(order.getCustomerId());
	        
	        return "order placed successfully";
	}
	
	
	public List<Order> getAllOrders() {
		return this.orderRepository.findAll();
	}
	
	
	public List<Order> getOrderDetails(Long id) {
	    List<Order> order=this.orderRepository.findByCustomerId(id);
//	    return order.isPresent() ? order.get() : null;
	    return order;
	}
	

}
