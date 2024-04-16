package com.example.demo.model;

import com.example.demo.utils.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authorities")
public class Authority {

	public Authority(AuthorityName authorityName) {
        this.name = authorityName;
    }
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    @Enumerated(EnumType.STRING)
	    private AuthorityName name;
	
}
