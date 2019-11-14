package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.SystemRolesPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemRolesPermissionRepository
 */
@Repository
public interface SystemRolesPermissionRepository extends JpaRepository<SystemRolesPermission, Integer>{

    
}