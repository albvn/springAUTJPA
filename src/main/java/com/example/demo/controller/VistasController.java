package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

	
	@GetMapping("/p3")
	public String prueba() {
		return "otra";
	}
	
	@GetMapping("/login")
	public String logeando() {
		return "login";
	}
	
	@GetMapping("/index")
	public String logeado() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String perfilAdmin() {
		return "admin";
	}
	
	@GetMapping("/denegado")
	public String accesoNoPermitido() {
		return "404";
	}
	
	@GetMapping("/register")
	public String newUser() {
		return "register";
	}
	
}
