package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.Editorial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EditorialRepository
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{

    
}