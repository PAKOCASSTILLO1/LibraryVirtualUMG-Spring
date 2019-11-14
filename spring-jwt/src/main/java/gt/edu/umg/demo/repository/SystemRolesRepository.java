package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.SystemRoles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemRolesRepository
 */
@Repository
public interface SystemRolesRepository extends JpaRepository<SystemRoles, Integer>{

    
}