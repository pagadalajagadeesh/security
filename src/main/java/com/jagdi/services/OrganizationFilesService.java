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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jagdi.entities.Organization;
import com.jagdi.entities.OrganizationFiles;
import com.jagdi.entities.User;
import com.jagdi.repositories.OrganizationFilesRepository;
import com.jagdi.repositories.OrganizationRepository;

@Service
public class OrganizationFilesService {

	@Autowired
	OrganizationFilesRepository organizationFilesRepository;

	@Autowired
	UserService userService;

	@Autowired
	OrganizationRepository organizationRepository;

	@Value("${filesfolderPath}")
	private String filesfolderPath;

	public List<OrganizationFiles> uploadFiles(Long orgId, MultipartFile[] files, Principal principal)
			throws Exception {
		List<OrganizationFiles> organizationFiles = new ArrayList();
		filesfolderPath = System.getProperty(filesfolderPath);
		String orgFilePath = filesfolderPath + File.separator + orgId;
		Path uploadPath = Paths.get(orgFilePath);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		Arrays.asList(files).stream().forEach(file -> {

			Path filePath = uploadPath.resolve(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				OrganizationFiles of = new OrganizationFiles();
				String fileUploadPath = uploadPath + File.separator + file.getOriginalFilename();
				of.setFileName(file.getOriginalFilename());
				of.setFilePath(fileUploadPath);
				User user = (User) userService.loadUserByUsername(principal.getName());
				of.setCreatedBy(user);
				of.setUpdatedBy(user);
				Organization organization = organizationRepository.findById(orgId).get();
				of.setOrganization(organization);
				organizationFilesRepository.save(of);
				organizationFiles.add(of);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		return organizationFiles;
	}

}
