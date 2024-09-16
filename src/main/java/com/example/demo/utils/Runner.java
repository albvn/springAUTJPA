package com.example.demo.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Authority;
import com.example.demo.model.User;
import com.example.demo.repositories.AuthorityRepository;
import com.example.demo.repositories.UserRepository;

@Component
public class Runner implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthorityRepository authorityRepository;
	
	//private final UserRepository userRepository;
	// private final AuthorityRepository authorityRepository;
	
	/*
	    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
	        this.userRepository = userRepository;
	        this.authorityRepository = authorityRepository;
	    }
	 */
	
	@Override
	public void run(String... args) throws Exception {
		

        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE),
                    new Authority(AuthorityName.USER)
            ));
        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                            new User("user1", new BCryptPasswordEncoder().encode("1"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                            new User("user2", new BCryptPasswordEncoder().encode("12"), List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                            new User("user3", new BCryptPasswordEncoder().encode("123"), List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())),
                            new User("userPrueba", new BCryptPasswordEncoder().encode("123"), List.of(this.authorityRepository.findByName(AuthorityName.USER).get()))
            		)
            );
        }
		
		
		
	}//fin

	
	
	
}
