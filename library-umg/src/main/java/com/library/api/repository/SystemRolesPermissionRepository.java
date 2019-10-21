package com.library.api.repository;

import com.library.api.entity.SystemRolesPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemRolesPermissionRepository
 */
@Repository
public interface SystemRolesPermissionRepository extends JpaRepository<SystemRolesPermission, Integer>{

    
}