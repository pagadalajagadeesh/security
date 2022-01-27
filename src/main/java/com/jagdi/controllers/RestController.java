package com.jagdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jagdi.entities.User;
import com.jagdi.repositories.UserRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public User getUser() {
		return userRepository.findByUsername("jagdi");

	}

}
