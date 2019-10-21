package com.library.api.repository;

import com.library.api.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

    
}