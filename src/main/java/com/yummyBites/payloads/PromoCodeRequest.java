package com.yummyBites.payloads;

public class PromoCodeRequest {

	private String promocode;

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public PromoCodeRequest(String promocode) {
		super();
		this.promocode = promocode;
	}

	public PromoCodeRequest() {
		super();
	}
	
}
