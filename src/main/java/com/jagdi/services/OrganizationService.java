package com.jagdi.services;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagdi.entities.Authority;
import com.jagdi.entities.Organization;
import com.jagdi.entities.User;
import com.jagdi.repositories.OrganizationFilesRepository;
import com.jagdi.repositories.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	UserService userService;
	
	@Autowired
	OrganizationFilesRepository organizationFilesRepository;

	public Organization addOrganization(Organization org, Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		org.setCreatedBy(user);
		org.setUpdatedBy(user);
		User contactPerson = (User) userService.findById(org.getContactPersonId());
		org.setContactPerson(contactPerson);
		return organizationRepository.save(org);
	}

	public Organization updateOrganization(Organization org, Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		Organization organization = organizationRepository.findById(org.getId()).get();

		if (organization == null) {
			return null;
		}
		if (user == null) {
			return null;
		} else {
			organization.setUpdatedBy(user);
		}

		organization.setUpdatedOn(new Date());
		if (org.getName() != null) {
			organization.setName(org.getName());
		}
		if (org.getCode() != null) {
			organization.setCode(org.getCode());
		}
		if (org.getAddress() != null) {
			organization.setAddress(org.getAddress());
		}
		if (org.getLocation() != null) {
			organization.setLocation(org.getLocation());
		}
		if (org.getEmail() != null) {
			organization.setEmail(org.getEmail());
		}
		if (org.getContactNumber() != null) {
			organization.setContactNumber(org.getContactNumber());
		}
		if (org.getEstablishedYear() > 0) {
			organization.setEstablishedYear(org.getEstablishedYear());
		}
		if (org.getContactPersonId() > 0) {
			User contactPerson = (User) userService.findById(org.getContactPersonId());
			organization.setContactPerson(contactPerson);
		}

		return organizationRepository.save(org);

	}

	public Organization enableOrganization(Long id, Principal principal) {
		Organization organization = organizationRepository.findById(id).get();
		if (organization != null) {
			organization.setActive(true);
			return organizationRepository.save(organization);
		}
		return null;

	}

	public Organization disableOrganization(Long id, Principal principal) {
		Organization organization = organizationRepository.findById(id).get();
		if (organization != null) {
			organization.setActive(false);
			return organizationRepository.save(organization);
		}
		return null;
	}

	public Organization getOrganization(Long id, Principal principal) {
		Organization organization = organizationRepository.findById(id).get();
		if (organization != null) {
			organization.setOrganizationFiles(organizationFilesRepository.findAllByOrganizationId(organization.getId()));
		}
		return organization;
	}

}
