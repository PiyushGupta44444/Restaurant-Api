//package com.yummyBites.entities;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
//
//@Entity
//public class AdminData {
//
//	@Id
//	private int id;
//	@NotEmpty(message = "Username cannot be empty")
//	@Email
//	private String userName;
//	@NotEmpty(message = "Please enter the password")
//	@Size(min=8,message = "Password must be greater than 8 digits")
//	private String password;
//	
//	
//	public AdminData() {
//		super();
//	}
//	
//	@Override
//	public String toString() {
//		return "AdminData [id=" + id + ", userName=" + userName + ", password=" + password + "]";
//	}
//	public AdminData(int id, String userName, String password) {
//		super();
//		this.id = id;
//		this.userName = userName;
//		this.password = password;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//}
