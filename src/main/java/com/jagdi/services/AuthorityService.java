package com.jagdi.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagdi.entities.Authority;
import com.jagdi.entities.User;
import com.jagdi.repositories.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	UserService userService;

	public Authority createAuthority(Authority auth,Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		auth.setCreatedBy(user);
		auth.setUpdatedBy(user);
		return authorityRepository.save(auth);
	}
	
	public Authority updateAuthority(Authority auth,Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		auth.setCreatedBy(user);
		auth.setUpdatedBy(user);
		return authorityRepository.save(auth);
	}
	
}
