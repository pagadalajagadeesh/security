package com.jagdi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jagdi.entities.Authority;
import com.jagdi.entities.ExceptionLog;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
