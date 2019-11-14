package gt.edu.umg.demo.repository;

import gt.edu.umg.demo.model.SystemPermissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SystemPermissionRepository
 */
@Repository
public interface SystemPermissionsRepository extends JpaRepository<SystemPermissions, Integer>{

    
}