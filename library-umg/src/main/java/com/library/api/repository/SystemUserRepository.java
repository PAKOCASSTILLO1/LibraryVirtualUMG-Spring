package com.library.api.repository;

import com.library.api.entity.SystemUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemUserRepository
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer>{

    SystemUser findByEmail(String email);
    
}