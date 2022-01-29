package com.jagdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jagdi.entities.User;
import com.jagdi.services.RoleService;

@Controller
public class ViewController {
	
	@Autowired
	RoleService roleService;
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Model model) {
		 model.addAttribute("user",new User());
		 model.addAttribute("roles", roleService.getAllRoles());
		return "addEmployee";
	}

}
