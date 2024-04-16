package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	@GetMapping("/demo")
	public String showdDemo() {
		return "funcionando!";
	}
	
	
}
