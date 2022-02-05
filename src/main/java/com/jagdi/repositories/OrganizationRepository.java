package com.jagdi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jagdi.entities.Organization;


@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
