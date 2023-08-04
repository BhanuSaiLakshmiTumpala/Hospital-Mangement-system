package com.hospital.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserController {
	static  Logger logger = Logger.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistration() {
		return new UserRegistrationDTO();
	}

	
	@GetMapping
	public String showRegistrationForm() {
		logger.info("Shown Registration Page");
		
		return "registration";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("user") UserRegistrationDTO regUserRegistration) {
		
		logger.info("User has been registerd registerUser method is called");
		userService.save(regUserRegistration);
		
		return "redirect:/registration?success";
		
	}
   
	
	
	
}
