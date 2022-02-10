package com.jagdi.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jagdi.entities.Company;
import com.jagdi.entities.CompanyFiles;
import com.jagdi.entities.Organization;
import com.jagdi.entities.OrganizationFiles;
import com.jagdi.entities.User;
import com.jagdi.repositories.CompanyFilesRepository;
import com.jagdi.repositories.CompanyRepository;

@Service
public class CompanyFilesService {

	@Autowired
	CompanyFilesRepository companyFilesRepository;

	@Autowired
	UserService userService;

	@Autowired
	CompanyRepository companyRepository;

	@Value("${filesfolderPath}")
	private String filesfolderPath;

	public List<CompanyFiles> uploadFiles(Long companyId, MultipartFile[] files, Principal principal) throws Exception {

		List<CompanyFiles> organizationFiles = new ArrayList();
		filesfolderPath = System.getProperty(filesfolderPath);
		String orgFilePath = filesfolderPath + File.separator + companyId;
		Path uploadPath = Paths.get(orgFilePath);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		Arrays.asList(files).stream().forEach(file -> {

			Path filePath = uploadPath.resolve(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				CompanyFiles cf = new CompanyFiles();
				String fileUploadPath = uploadPath + File.separator + file.getOriginalFilename();
				cf.setFileName(file.getOriginalFilename());
				cf.setFilePath(fileUploadPath);
				User user = (User) userService.loadUserByUsername(principal.getName());
				cf.setCreatedBy(user);
				cf.setUpdatedBy(user);
				Company company = companyRepository.findById(companyId).get();
				cf.setCompanyId(company.getId());
				companyFilesRepository.save(cf);
				organizationFiles.add(cf);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		return organizationFiles;

	}

}
