package com.library.api.repository;

import com.library.api.entity.SystemUserRol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemUserRolRepository
 */
@Repository
public interface SystemUserRolRepository extends JpaRepository<SystemUserRol, Integer>{

    
}