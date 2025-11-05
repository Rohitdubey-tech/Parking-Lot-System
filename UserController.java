package com.sushant.parkingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.parkingSystem.model.User;
import com.sushant.parkingSystem.service.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
		
		return "User Registered Successfully";
	}
	
	@GetMapping("/current-user")
	public User getMethodName(Authentication auth) {
		return userService.getCurrentUser(auth);
	}
}
