package com.library.api.repository;

import java.util.List;

import com.library.api.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

    @Query("select a from Author a where a.name like %?1%")
    List<Author> busqueda(String data);
}