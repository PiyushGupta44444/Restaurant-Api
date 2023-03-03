package com.yummyBites.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yummyBites.entities.Customer;
import com.yummyBites.payloads.CustomerDto;
import com.yummyBites.repositories.CustomerRepository;
import com.yummyBites.security.JwtTokenHelper;
import com.yummyBites.services.CustomerService;
import com.yummyBites.services.EmailService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@SecurityRequirement(name = "restaurant-docs")
public class CustomerController {
	Random random = new Random(1000);
	@Autowired
	private EmailService emailService;
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/signup")
	public Customer signup(@RequestBody CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setAddress(customerDto.getAddress());
		customer.setEmail(customerDto.getEmail());
		customer.setName(customerDto.getName());
		customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
		customer.setNumber(customerDto.getNumber());
		customer.setRole("ROLE_CUSTOMER");
		return this.customerService.addCustomer(customer);
	}

	@PostMapping("/login")
	public Customer login(@RequestBody CustomerDto customerDto) {
		Optional<Customer> cusOptional = this.customerService.findCustomerByEmail(customerDto.getEmail());
		if (cusOptional.isPresent()
				&& passwordEncoder.matches(customerDto.getPassword(), cusOptional.get().getPassword())) {
			System.out.println("logged in");
			return cusOptional.get();
		}
		System.out.println("not working");
		return null;
	}

	
	@PostMapping("/logout")
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
		System.out.println("logged out");
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list=this.customerService.getAllCustomers();
		return ResponseEntity.ok(list);

	}

	@PreAuthorize("hasRole('CUSTOMER')")
	@PostMapping("/customer/change-password")
	public ResponseEntity<String> changePassword(@RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass,
			HttpServletRequest request) {
		String requestToken = request.getHeader("Authorization");
		String token = requestToken.substring(7);
		String username = this.jwtTokenHelper.extractUsername(token);
		Customer customer = this.customerRepository.findByEmail(username);
		if (passwordEncoder.matches(oldPass, customer.getPassword())) {
			customer.setPassword(passwordEncoder.encode(newPass));
			this.customerRepository.save(customer);
			return ResponseEntity.ok("Your Password is changed successfully!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You have entered wrong password");
	}

	@PostMapping("/forgot-password")
	public String verifyEmail(@RequestParam("email") String email, HttpSession session) {
		Customer customer = this.customerRepository.findByEmail(email);
		if (customer == null) {
			System.out.println("user do not exist");
			return "forgot email page";
		} else {
			int otp = random.nextInt(99999);
			System.out.println(otp + email);
			boolean f = this.emailService.sendEmail("verification", "otp = " + otp, email);
			if (f) {
				session.setAttribute("myOtp", otp);
				session.setAttribute("myEmail", email);
				return "sent";
			} else {
				return "not done";
			}
		}
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(HttpSession session, @RequestParam("otp") int otp) {
		int myOtp = (int) session.getAttribute("myOtp");
		if (myOtp == otp) {
			return ResponseEntity.ok("Page for entering new password");
		} else {
			session.setAttribute("message", "sry wrong otp");
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("you have entered wrong otp");
		}
	}

	@PostMapping("/change-password")
	public ResponseEntity<String> changePassword(@RequestParam("newPass") String newPass, HttpSession session) {
		String email = (String) session.getAttribute("myEmail");
		Customer customer = this.customerRepository.findByEmail(email);
		customer.setPassword(passwordEncoder.encode(newPass));
		this.customerRepository.save(customer);
		System.out.println("return login page");
		return ResponseEntity.ok("password Changed successfully");
	}

}
