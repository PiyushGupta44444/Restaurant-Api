package com.yummyBites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yummyBites.entities.PromoCode;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long>{
	public PromoCode findByCode(String promocode);
		
	public String deleteByCode(String promocode);
	
}
