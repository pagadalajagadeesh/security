package com.jagdi.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jagdi.entities.Role;
import com.jagdi.entities.User;
import com.jagdi.handlers.PasswordHandler;
import com.jagdi.repositories.RoleRepository;
import com.jagdi.repositories.UserRepository;

@Component
public class Comp {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired 
	PasswordHandler passwordHandler;

	/*
	 * @PostConstruct private void exec() { roleRepository.deleteAll();
	 * roleRepository.save(new Role("ADMIN", "admin user")); roleRepository.save(new
	 * Role("USER", "normal user")); userRepository.deleteAll(); Set set = new
	 * HashSet(); roleRepository.findAll().forEach(a -> set.add(a));
	 * userRepository.save(new User("jagdi",passwordHandler.encode("jagdi") , set));
	 * }
	 */

}
