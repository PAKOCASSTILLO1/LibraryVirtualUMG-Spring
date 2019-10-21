package com.library.api.repository;

import com.library.api.entity.SystemPermissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemPermissionRepository
 */
@Repository
public interface SystemPermissionsRepository extends JpaRepository<SystemPermissions, Integer>{

    
}