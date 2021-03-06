package com.jagdi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagdi.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
