package com.library.api.repository;

import com.library.api.entity.Editorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EditorialRepository
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{

    
}