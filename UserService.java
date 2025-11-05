package com.sushant.parkingSystem.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sushant.parkingSystem.model.User;

public interface UserService {

	UserDetails save(User user);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public User getCurrentUser(Authentication auth);

}