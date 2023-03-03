package com.yummyBites.payloads;

public class CustomerDto {

	private Long id;
	private String name;
	private String address;
	private Long number;
	private String email;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDto(Long id, String name, String address, Long number, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public CustomerDto() {
		super();
	}

}
