//package com.yummyBites.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.yummyBites.entities.AdminData;
//import com.yummyBites.repositories.AdminRepository;
//@Component
//public class AdminService {
//
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	public AdminData getDataById(int id) {
//		AdminData adminData=null;
//		try {
//		adminData=this.adminRepository.findById(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return adminData;
//	}
//}
