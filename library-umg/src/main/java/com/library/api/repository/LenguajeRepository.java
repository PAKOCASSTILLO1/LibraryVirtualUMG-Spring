package com.library.api.repository;

import com.library.api.entity.Lenguaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LenguajeRepository
 */
@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Integer>{

    
}