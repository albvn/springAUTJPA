package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.security.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//Optional<User> 
		var user=this.userRepository.findByUsername(username);
		
		if(user.isPresent()) {
			return new SecurityUser(user.get());
		} 
		
		throw new UsernameNotFoundException("Error en usuario: "+username);
	}
	
	/*
	 	public void guardar(UsuarioModel usuarioModel){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    usuarioModel.setPassword(passwordEncoder.encode(usuarioModel.getPassword()));
    usuarioRepository.save(usuarioModel);
		}
	
	 */
	
	
	
}
