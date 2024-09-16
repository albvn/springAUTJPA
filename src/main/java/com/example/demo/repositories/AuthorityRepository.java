package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Authority;
import com.example.demo.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	Optional<Authority> findByName(AuthorityName name);
	
}

