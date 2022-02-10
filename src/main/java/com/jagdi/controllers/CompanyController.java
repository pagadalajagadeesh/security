package com.jagdi.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jagdi.entities.Company;
import com.jagdi.entities.CompanyFiles;
import com.jagdi.entities.Organization;
import com.jagdi.entities.OrganizationFiles;
import com.jagdi.services.CompanyFilesService;
import com.jagdi.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyFilesService companyFilesService;
	
	
	@PostMapping("/add")
	public Company addCompany(@RequestBody Company cmp, Principal principal) {
		return companyService.addCompany(cmp, principal);
	}
	
	@PostMapping("/update")
	public Company updateCompany(@RequestBody Company org, Principal principal) {
		return companyService.updateCompany(org, principal);
	}
	
	@GetMapping("/get")
	public Company getCompany(@RequestParam Long id, Principal principal) {
		return companyService.getCompany(id, principal);
	}
	
	@PostMapping("/enable")
	public Company enableCompany(@RequestParam Long id, Principal principal) {
		return companyService.enableCompany(id, principal);
	}

	@PostMapping("/disable")
	public Company disableCompany(@RequestParam Long id, Principal principal) {
		return companyService.disableCompany(id, principal);
	}
	
	@PostMapping("/uploadFiles")
	public List<CompanyFiles> uploadFiles(@RequestParam("companyId") Long companyId,@RequestParam("files") MultipartFile[] files, Principal principal) throws Exception {
		return companyFilesService.uploadFiles(companyId,files,principal);
	}
}
