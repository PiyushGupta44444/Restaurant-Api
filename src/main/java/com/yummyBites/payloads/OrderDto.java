package com.yummyBites.payloads;



public class OrderDto {

	private Long customerId;
	 private String address;

	  public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderDto(Long customerId, String address) {
		super();
		this.customerId = customerId;
		this.address = address;
	}

	public OrderDto() {
		super();
	}

	public Long getCustomerId() {
	    return customerId;
	  }

	  public void setCustomerId(Long customerId) {
	    this.customerId = customerId;
	  }

	 
}
