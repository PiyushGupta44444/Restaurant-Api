package com.yummyBites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.payloads.JwtAuthResponse;
import com.yummyBites.payloads.JwtRequest;
import com.yummyBites.security.JwtTokenHelper;
import com.yummyBites.services.UserDetailsServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "restaurant-docs")
public class AuthController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/generate-token")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtRequest jwtRequest) {
		System.out.println("working");

		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		}
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetails);
		return ResponseEntity.ok(new JwtAuthResponse(token));

	}
}
