package com.library.api.repository;

import com.library.api.entity.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DocumentRepository
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{

    
}