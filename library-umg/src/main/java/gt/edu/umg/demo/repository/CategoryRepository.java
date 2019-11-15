package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

    
}