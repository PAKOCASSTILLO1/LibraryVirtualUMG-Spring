package gt.edu.umg.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.umg.demo.model.TcUser;

@Repository
public interface TcUserRepository extends JpaRepository<TcUser, Integer> {

    Optional<TcUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}