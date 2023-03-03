package com.yummyBites.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "restaurant-docs")
public class MyController {

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("home page");
	}

	@GetMapping("/home")
	public ModelAndView welcome() {
		ModelAndView mdAndView=new ModelAndView("home");
		return mdAndView;
	}

}
