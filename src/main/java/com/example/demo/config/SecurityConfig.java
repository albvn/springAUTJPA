package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf().disable()
				.httpBasic()
			.and()
				.authorizeHttpRequests()
				.anyRequest().permitAll()
				//.anyRequest().authenticated()
				//.anyRequest().hasAnyAuthority("USER","READ")
				//.requestMatchers(HttpMethod.POST,"/loginprueba").hasAuthority("ADMIN")
				//.anyRequest().authenticated()
			.and()				
				.build();
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		
		 UserDetails user = User.withUsername("nombre1")				  
				.password("1234")
				.roles("admin")
				.build();
		
			return new InMemoryUserDetailsManager(user);	
	}
	*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	 
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
}
