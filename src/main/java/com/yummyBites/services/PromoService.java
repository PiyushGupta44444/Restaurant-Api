package com.yummyBites.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yummyBites.entities.PromoCode;

import com.yummyBites.repositories.PromoCodeRepository;

import jakarta.transaction.Transactional;

@Service
public class PromoService {

	@Autowired
	private PromoCodeRepository promoCodeRepository;
	
	public List<PromoCode> getAllPromo() {
		return this.promoCodeRepository.findAll();
	}
	public PromoCode getPromoCode(String promocode) {
		PromoCode pCode= this.promoCodeRepository.findByCode(promocode);
		if(pCode!=null) {
			return pCode;
		}
		return null;
	}
	
	public String createPromoCode(PromoCode promoCode) {
		this.promoCodeRepository.save(promoCode);
		return "promocode added successfully!";
	}
	@Transactional
	public String deletePromoCode(String promocode) {
//		if(getPromoCode(promocode)!=null) {
		this.promoCodeRepository.deleteByCode(promocode);
		return "promo deleted successfully";
//		}
//		return "not exist";
	}
}
