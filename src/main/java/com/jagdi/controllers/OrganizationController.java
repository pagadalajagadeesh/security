package com.jagdi.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jagdi.entities.Authority;
import com.jagdi.entities.Organization;
import com.jagdi.entities.OrganizationFiles;
import com.jagdi.services.OrganizationFilesService;
import com.jagdi.services.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	OrganizationFilesService organizationFilesService;

	@PostMapping("/add")
	public Organization addOrganization(@RequestBody Organization org, Principal principal) {
		return organizationService.addOrganization(org, principal);
	}

	@PostMapping("/update")
	public Organization updateOrganization(@RequestBody Organization org, Principal principal) {
		return organizationService.updateOrganization(org, principal);
	}
	
	@GetMapping("/get")
	public Organization getOrganization(@RequestParam Long id, Principal principal) {
		return organizationService.getOrganization(id, principal);
	}

	@PostMapping("/enable")
	public Organization enableOrganization(@RequestParam Long id, Principal principal) {
		return organizationService.enableOrganization(id, principal);
	}

	@PostMapping("/disable")
	public Organization disableOrganization(@RequestParam Long id, Principal principal) {
		return organizationService.disableOrganization(id, principal);
	}

	@PostMapping("/uploadFiles")
	public List<OrganizationFiles> uploadFiles(@RequestParam("orgId") Long orgId,@RequestParam("files") MultipartFile[] files, Principal principal) throws Exception {
		return organizationFilesService.uploadFiles(orgId,files,principal);
	}

}
