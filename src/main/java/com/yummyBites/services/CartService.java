package com.yummyBites.services;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yummyBites.entities.Cart;
import com.yummyBites.entities.CartItem;
import com.yummyBites.entities.Dish;
import com.yummyBites.entities.PromoCode;
import com.yummyBites.payloads.CartItemDto;
import com.yummyBites.repositories.CartItemRepo;
import com.yummyBites.repositories.CartRepository;
import com.yummyBites.repositories.DishRepository;



@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private DishRepository dishRepository;
	@Autowired
	private CartItemRepo cartItemRepo;
	@Autowired
	private PromoService promoService;
	
	public Cart getCart(Long customer_id) {
		Cart cart=this.cartRepository.findUserById(customer_id);
		return cart;
	}
	public void saveCart(Cart ci) {
		this.cartRepository.save(ci);
	}
	
	 public void clearCart(Long customer_id) {
	      Cart cart =this.cartRepository.findUserById(customer_id);
	     	      if (cart != null) {
	     	    	 this.cartRepository.delete(cart);

//	          cart.setCartItems(new ArrayList<>());
//	          cart.setTotalPrice(0.0);
//	         this.cartRepository.save(cart);
	       }
	 }
	
	 
	 public String addItemCart(CartItemDto cartItemDto) {
		 Cart cart = this.cartRepository.findUserById(cartItemDto.getCustomerId());
		 Dish dish = this.dishRepository.findDishById(cartItemDto.getDishId());
		 if (dish == null) {
	            return "Dish not found";
	        }
		 if(cart==null) {
			 cart=new Cart();
			 cart.setId(cartItemDto.getCustomerId());
			 cart.setCustomer_id(cartItemDto.getCustomerId());
			 cart.setCartItems(new ArrayList<>());
		 }
		  Optional<CartItem> cartItemOptional =cart.getCartItems().stream()
	                .filter(ci -> ci.getDish().getId().equals(cartItemDto.getDishId()))
	                .findFirst();
		  if (cartItemOptional.isPresent()) {
	            CartItem cartItem = cartItemOptional.get();
	            cartItem.setQuantity(cartItem.getQuantity() + 1);
		  } else { 
	            CartItem cartItem = new CartItem();
	            cartItem.setDish(dish);
	            cartItem.setQuantity(1);
	            cartItem.setCart(cart);
	            cartItem.setTotalPrice(dish.getPrice());
	            cart.getCartItems().add(cartItem);
	        }
		  cart.setTotalPrice(cart.getTotalPrice() + dish.getPrice());
		  String promo=cart.getPromocode();
          if(promo!=null) {
          	PromoCode promoCode=this.promoService.getPromoCode(promo);
          	double total=cart.getTotalPrice();
          	cart.setDiscountedTotal(total-(total*promoCode.getDiscount()));
          }else {
				cart.setDiscountedTotal(cart.getTotalPrice());
			}
		  this.cartRepository.save(cart);
		  return "item added to cart";
	}
	 
	 
	public String removeItemFromCart(CartItemDto cartItemDto) {
		 Cart cart =this.cartRepository.findUserById(cartItemDto.getCustomerId());
		 if(cart==null) {
//			 cart=new Cart();
//			 cart.setCustomer_id(cartItemDto.getCustomerId());
//			 cart.setCartItems(new ArrayList<>());
			 return "cart not found";
		 }else {
		 Optional<CartItem> cartItemOptional = cart.getCartItems().stream()
	                .filter(ci -> ci.getDish().getId().equals(cartItemDto.getDishId()))
	                .findFirst();
		 if (cartItemOptional.isPresent()) {
	            CartItem cartItem = cartItemOptional.get();
	            if (cartItem.getQuantity() > 1) {
	                cartItem.setQuantity(cartItem.getQuantity() - 1);
	            } else {  
	             cart.getCartItems().remove(cartItem);
	             this.cartItemRepo.deleteById(cartItem.getId());
	            }
	            cart.setTotalPrice(cart.getTotalPrice() - cartItem.getDish().getPrice());
	            String promo=cart.getPromocode();
	            if(promo!=null) {
	            	PromoCode promoCode=this.promoService.getPromoCode(promo);
	            	double total=cart.getTotalPrice();
	            	cart.setDiscountedTotal(total-(total*promoCode.getDiscount()));
	            }else {
					cart.setDiscountedTotal(cart.getTotalPrice());
				}
	            this.cartRepository.save(cart);
	            return "Item removed from cart successfully!";
		 }
		 else {
			return "Cart item not found";
		}}
	 }
	 
	 
	
//	 public Cart addItemToCart(Long customer_id, Dish dish, int quantity) {
//	      Cart cart = this.cartRepository.findUserById(customer_id);
//	      if (cart == null) {
//	          cart = new Cart();
//	          cart.setCustomer_id(customer_id);
//	          cart.setCartItems(new ArrayList<>());
//	      }
//	      List<CartItem> cartItems = cart.getCartItems();
//	      Optional<CartItem> optionalCartItem = cartItems.stream().filter(ci -> ci.getDish().getId().equals(dish.getId())).findFirst();
//	      if (optionalCartItem.isPresent()) {
//	          CartItem cartItem = optionalCartItem.get();
//	          int newQuantity = cartItem.getQuantity() + quantity;
//	          cartItem.setQuantity(newQuantity);
//	          cartItem.setTotalPrice(cartItem.getDish().getPrice() * newQuantity);
//	       } else {
//	          CartItem cartItem = new CartItem();
//	          cartItem.setDish(dish);
//	          cartItem.setQuantity(quantity);
//	          cartItem.setTotalPrice(dish.getPrice() * quantity);
//	          cartItems.add(cartItem);
//	       }
//	      double totalPrice = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
//	      cart.setTotalPrice(totalPrice);
//	      Cart savedCart = this.cartRepository.save(cart);
//	      return savedCart;
//	 }
//	
//	 public Cart removeItemFromCart(Long customer_id, Dish dish, int quantity) {
//		 Cart cart =this.cartRepository.findUserById(customer_id);
//		 if (cart == null) {
//	         return null;
//	      }
//		 List<CartItem> cartItems = cart.getCartItems();
//	      Optional<CartItem> optionalCartItem = cartItems.stream().filter(ci -> ci.getDish().getId().equals(dish.getId())).findFirst();
//
//	      if (optionalCartItem.isPresent()) {
//	         CartItem cartItem = optionalCartItem.get();
//	         int newQuantity = cartItem.getQuantity() - quantity;
//	         if (newQuantity > 0) {
//	             cartItem.setQuantity(newQuantity);
//	             cartItem.setTotalPrice(cartItem.getDish().getPrice() * newQuantity);
//	          } else {
//	             cartItems.remove(cartItem);
//	          }
//	         double totalPrice = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
//	         cart.setTotalPrice(totalPrice);
//
//	         Cart savedCart = cartRepository.save(cart);
//	         return savedCart;
//	      }
//	      return cart;
//	 }
//	 
	 
	  
}
