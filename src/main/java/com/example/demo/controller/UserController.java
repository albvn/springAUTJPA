package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;

@Controller
public class UserController {

	@Autowired
	AuthService userService;
	
	/*
	@PostMapping
	public String login() {
		return "proceso de logeo OK";
	}
	*/
	
	@PostMapping("/register")
	public String registro(@ModelAttribute RegisterRequest request) {
		
		userService.register(request);
		
		return "login";
	}
	
	

	
	
	
}
