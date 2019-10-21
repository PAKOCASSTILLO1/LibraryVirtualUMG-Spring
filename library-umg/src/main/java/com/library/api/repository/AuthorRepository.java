package com.library.api.repository;

import com.library.api.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

    
}