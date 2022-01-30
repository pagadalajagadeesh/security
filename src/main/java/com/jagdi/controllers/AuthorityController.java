package com.jagdi.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jagdi.entities.Authority;
import com.jagdi.entities.User;
import com.jagdi.services.AuthorityService;
import com.jagdi.services.UserService;

@RestController
@RequestMapping("/authority")
public class AuthorityController {

	@Autowired
	AuthorityService authorityService;
	
	

	@PostMapping("/add")
	public Authority createAuthority(@RequestBody Authority auth,Principal principal) {
		return authorityService.createAuthority(auth,principal);
	}
	
	@PostMapping("/update")
	public Authority updateAuthority(@RequestBody Authority auth,Principal principal) {
		return authorityService.updateAuthority(auth,principal);
	}

}
