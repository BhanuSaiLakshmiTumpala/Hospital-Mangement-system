package com.hospital.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String homePage() {
		logger.info("Home page request is called");
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		logger.info("login method is called");
		return "login";
    }
	
	//after login
	@GetMapping("/dologin")
	public String home() {
		logger.info("doLogin request is called ");
		return "index";
	}
    
	

}
