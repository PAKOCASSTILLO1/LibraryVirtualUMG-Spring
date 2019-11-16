package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CountryRepository
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

    
}