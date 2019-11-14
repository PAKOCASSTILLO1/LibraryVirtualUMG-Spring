package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.Lenguaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LenguajeRepository
 */
@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Integer>{

    
}