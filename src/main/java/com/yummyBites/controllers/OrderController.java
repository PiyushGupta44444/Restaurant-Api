package com.yummyBites.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.entities.Order;
import com.yummyBites.payloads.OrderDto;
import com.yummyBites.services.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@SecurityRequirement(name = "restaurant-docs")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	
//	  @PostMapping("/order/{customer_id}")
//	   public ResponseEntity<String> checkoutCart(@PathVariable Long customer_id) {
//	      Cart cart =this.cartService.getCart(customer_id);
//
//	      if (cart == null || cart.getCartItems().isEmpty()) {
//	         return ResponseEntity.badRequest().body("Cart is empty");
//	      }
//
//	      @SuppressWarnings("unused")
//		Order order =this.orderService.createOrder(customer_id, cart);
//
//	      cartService.clearCart(customer_id);
//
//	      return ResponseEntity.ok("Order placed successfully");
//	   }

	
	@PostMapping("/place-order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto){
	    String status=this.orderService.placeOrder(orderDto);
	    return ResponseEntity.ok(status);
	}
	
	@GetMapping("/getOrder/{id}")
	public ResponseEntity<List<Order>> getOrder(@PathVariable("id") Long id) {
	  List<Order> order=this.orderService.getOrderDetails(id);
	    if (order.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	    System.out.println(order);
	    return ResponseEntity.ok().body(order);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> list=this.orderService.getAllOrders();
		return ResponseEntity.ok(list);
	}
	
	
}
