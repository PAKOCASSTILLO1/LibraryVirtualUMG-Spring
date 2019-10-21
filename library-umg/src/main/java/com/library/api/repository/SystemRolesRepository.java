package com.library.api.repository;

import com.library.api.entity.SystemRoles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemRolesRepository
 */
@Repository
public interface SystemRolesRepository extends JpaRepository<SystemRoles, Integer>{

    
}