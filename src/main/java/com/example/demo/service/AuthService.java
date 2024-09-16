package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repositories.AuthorityRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.AuthorityName;

@Service
public class AuthService {
	User user;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthorityRepository authorityRepository;

	public Boolean register(RegisterRequest regRequest) {
		user=User.builder()
				.username(regRequest.getUsername())
				.password(new BCryptPasswordEncoder().encode(regRequest.getPassword()))
				.authorities(List.of(authorityRepository.findByName(AuthorityName.USER).get()))
				.build();
		
		userRepository.save(user);
		return true;
	}
	
	
	
	
}
