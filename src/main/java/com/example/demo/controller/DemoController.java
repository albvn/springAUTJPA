package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/demo2")
	public String demo() {
		return "Prueba OK";
	}
	
	
	@PostMapping("loginprueba")
	public String logeado() {
		return "Acceso correcto";
	}
	
	
}
