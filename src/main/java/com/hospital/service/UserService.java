package com.hospital.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hospital.controller.UserRegistrationDTO;
import com.hospital.entites.User;

public interface UserService extends UserDetailsService  {
	
	public User save(UserRegistrationDTO userRegistration);
	

}
