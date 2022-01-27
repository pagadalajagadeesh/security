package com.jagdi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagdi.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}