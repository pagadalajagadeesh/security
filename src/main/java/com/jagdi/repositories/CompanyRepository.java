package com.jagdi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jagdi.entities.Company;
import com.jagdi.entities.OrganizationFiles;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


}
