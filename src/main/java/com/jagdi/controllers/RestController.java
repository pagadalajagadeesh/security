package com.jagdi.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jagdi.exceptions.NoDataException;
import com.jagdi.entities.User;
import com.jagdi.repositories.RoleRepository;
import com.jagdi.repositories.UserRepository;
import com.jagdi.utilities.JSONConverter;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	JSONConverter jsonConverter;

	@GetMapping
	public User getUser() {
		return userRepository.findByUsername("jagdi");

	}

//	@GetMapping
//	@RequestMapping("/exec")
//	public String getExec() throws NoDataException {
//
//		Set set = new HashSet();
//		roleRepository.findAll().forEach(a -> set.add(a));
//		throw new NoDataException("description", jsonConverter.getJson(new User("jagdi", "jagdi", set)));
//
//	}

}
