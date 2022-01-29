package com.jagdi.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHandler {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoderr;

	public String encode(String password) {
		return bCryptPasswordEncoderr.encode(password);
	}

}
