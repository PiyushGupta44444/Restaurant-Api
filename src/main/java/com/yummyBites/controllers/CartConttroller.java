package com.yummyBites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.entities.Cart;
import com.yummyBites.entities.PromoCode;
import com.yummyBites.payloads.CartItemDto;
import com.yummyBites.payloads.PromoCodeRequest;
import com.yummyBites.services.CartService;
import com.yummyBites.services.PromoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "restaurant-docs")
@PreAuthorize("hasRole('CUSTOMER')")
public class CartConttroller {

	@Autowired
	private CartService cartService;
	@Autowired
	private PromoService promoService;
	
	@PostMapping("/addCartItem")
	public ResponseEntity<String> addItems(@RequestBody CartItemDto cartItemDto) {
		String status=this.cartService.addItemCart(cartItemDto);
		return ResponseEntity.ok(status);
	}
	
	@PostMapping("/removeItem")
	public ResponseEntity<String> removeItem(@RequestBody CartItemDto cartItemDto){
		String status=this.cartService.removeItemFromCart(cartItemDto);
		return ResponseEntity.ok(status);
	}
	
	@DeleteMapping("/clear-cart/{id}")
	public ResponseEntity<String> clearCart(@PathVariable("id") Long id) {
		this.cartService.clearCart(id);
		return ResponseEntity.ok("cart is clear");
	}
	@GetMapping("/get-cart/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") Long id){
		 Cart cart= this.cartService.getCart(id);
		 if(cart==null) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.ok(cart);
	}
	@PostMapping("/{id}/applyPromo")
	public ResponseEntity<String> applyPromoCode(@PathVariable("id")Long id,@RequestBody PromoCodeRequest promoCodeRequest){
		 String promoCode =promoCodeRequest.getPromocode();
		 Cart cart=this.cartService.getCart(id);
		 if (cart == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cart not found for user ID: " + id);
	        }
		 if (promoCode == null || promoCode.isEmpty()) {
	            return ResponseEntity.badRequest().body("Promo code cannot be empty");
	        }
		 PromoCode promo =this.promoService.getPromoCode(promoCode);
		  if (promo == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Promo code not found: " + promoCode);
	        }
		  cart.setPromocode(promoCode);
		  double total=cart.getTotalPrice();
		  double discount=promo.getDiscount();
		  double discountedTotal=total-(total*discount);
		  cart.setDiscountedTotal(discountedTotal);
		  this.cartService.saveCart(cart);
		  return ResponseEntity.ok("promo applied");
	}
	@PostMapping("/{id}/removePromo")
	public ResponseEntity<String> removePromoCode(@PathVariable("id")Long id){
		 Cart cart=this.cartService.getCart(id);
		 cart.setDiscountedTotal(cart.getTotalPrice());
		 cart.setPromocode(null);
		 this.cartService.saveCart(cart);
		 return ResponseEntity.ok("promocode removed");
	}
	
}
