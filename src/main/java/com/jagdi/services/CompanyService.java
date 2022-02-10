package com.jagdi.services;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jagdi.entities.Company;
import com.jagdi.entities.CompanyFiles;
import com.jagdi.entities.Organization;
import com.jagdi.entities.OrganizationFiles;
import com.jagdi.entities.User;
import com.jagdi.repositories.CompanyFilesRepository;
import com.jagdi.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	UserService userService;
	
	@Autowired
	CompanyFilesRepository companyFilesRepository;

	public Company addCompany(Company cmp, Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		cmp.setCreatedBy(user);
		cmp.setUpdatedBy(user);
		User contactPerson = (User) userService.findById(cmp.getContactPersonId());
		cmp.setContactPerson(contactPerson);
		return companyRepository.save(cmp);
	}

	public Company updateCompany(Company cmp, Principal principal) {
		User user = (User) userService.loadUserByUsername(principal.getName());
		Company company = companyRepository.findById(cmp.getId()).get();

		if (company == null) {
			return null;
		}
		if (user == null) {
			return null;
		} else {
			company.setUpdatedBy(user);
		}

		company.setUpdatedOn(new Date());
		if (cmp.getName() != null) {
			company.setName(cmp.getName());
		}
		if (cmp.getCode() != null) {
			company.setCode(cmp.getCode());
		}
		if (cmp.getAddress() != null) {
			company.setAddress(cmp.getAddress());
		}
		if (cmp.getLocation() != null) {
			company.setLocation(cmp.getLocation());
		}
		if (cmp.getEmail() != null) {
			company.setEmail(cmp.getEmail());
		}
		if (cmp.getContactNumber() != null) {
			company.setContactNumber(cmp.getContactNumber());
		}
		if (cmp.getEstablishedYear() > 0) {
			company.setEstablishedYear(cmp.getEstablishedYear());
		}
		if (cmp.getContactPersonId() > 0) {
			User contactPerson = (User) userService.findById(cmp.getContactPersonId());
			company.setContactPerson(contactPerson);
		}

		return companyRepository.save(company);

	}

	public Company enableCompany(Long id, Principal principal) {
		Company company = companyRepository.findById(id).get();
		if (company != null) {
			company.setActive(true);
			return companyRepository.save(company);
		}
		return null;
	}

	public Company disableCompany(Long id, Principal principal) {
		Company company = companyRepository.findById(id).get();
		if (company != null) {
			company.setActive(false);
			return companyRepository.save(company);
		}
		return null;
	}

	public Company getCompany(Long id, Principal principal) {
		Company company = companyRepository.findById(id).get();
		if (company != null) {
			List<CompanyFiles> files =	companyFilesRepository.findByCompanyId(company.getId());
			company.setCompanyFiles(files);
		}
		return company;
	}

}
