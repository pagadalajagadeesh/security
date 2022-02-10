package com.jagdi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jagdi.entities.CompanyFiles;

@Repository
public interface CompanyFilesRepository extends JpaRepository<CompanyFiles, Long>{

	List<CompanyFiles> findByCompanyId(long id);

}
