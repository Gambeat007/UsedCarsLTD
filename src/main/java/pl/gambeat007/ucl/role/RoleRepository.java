package pl.gambeat007.ucl.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class with JpaRepository (and it's methods) implemented plus
 * additional own methods and queries defined
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UCLRole name);
}
