package com.sushant.parkingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sushant.parkingSystem.model.User;
import com.sushant.parkingSystem.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService{
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails save(User user) {
		return userRepo.save(user);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
	
	public User getCurrentUser(Authentication auth) {
		User user = null;
		if(auth != null && auth.isAuthenticated())
		{
			user =  (User) auth.getPrincipal();
		}
		return user;
	}
}
