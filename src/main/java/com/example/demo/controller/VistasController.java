package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

	
	@GetMapping("/index1")
	public String prueba() {
		return "index";
	}
	
	@GetMapping("/logeado")
	public String logeado() {
		return "index2";
	}
	
}
