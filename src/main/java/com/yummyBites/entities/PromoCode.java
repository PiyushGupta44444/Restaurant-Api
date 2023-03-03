package com.yummyBites.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promo_codes")
public class PromoCode {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	    @Column(nullable = false, unique = true)
	    private String code;

	    @Column(nullable = false)
	    private double discount;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public PromoCode(Long id, String code, double discount) {
			super();
			this.id = id;
			this.code = code;
			this.discount = discount;
		}

		public PromoCode() {
			super();
		}

}
