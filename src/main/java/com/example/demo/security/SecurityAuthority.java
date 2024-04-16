package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.model.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{
	
	public final Authority authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority.getName().toString();
	}

}
