package com.yummyBites.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.entities.PromoCode;
import com.yummyBites.payloads.PromoCodeRequest;
import com.yummyBites.services.PromoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "restaurant-docs")
public class PromoController {

	@Autowired
	private PromoService promoService;
	
	@GetMapping("/getpromocode")
	public ResponseEntity<PromoCode> getPromo(@RequestBody PromoCodeRequest promoCodeRequest){
		PromoCode promoCode= this.promoService.getPromoCode(promoCodeRequest.getPromocode());
		if(promoCode==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(promoCode);
	}
	@GetMapping("/getAllPromo")
	public ResponseEntity<List<PromoCode>> getAll(){
		List<PromoCode> promoCodes=this.promoService.getAllPromo();
		return ResponseEntity.ok(promoCodes);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createPromo")
	public ResponseEntity<String> createPromoCode(@RequestBody PromoCode promoCode){
		String status=this.promoService.createPromoCode(promoCode);
		return ResponseEntity.ok(status);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deletePromo")
	public ResponseEntity<String> deletePromoCode(@RequestBody PromoCodeRequest promoCodeRequest){
		
			String status=this.promoService.deletePromoCode(promoCodeRequest.getPromocode());
			return ResponseEntity.ok(status);
		
		
//		if(this.promoService.getPromoCode(promoCodeRequest.getPromocode())!=null) {
//		this.promoService.deletePromoCode(promoCodeRequest.getPromocode());
//		return ResponseEntity.ok("Promocode deleted succesfully");
//		}else {
//			return ResponseEntity.ok("promocode not exists");
//		}
	}
}
