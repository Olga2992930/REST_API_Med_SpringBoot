package se.deved.apiApp.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { // Ändra UUID → Long
    Optional<UserEntity> findByUsername(String name);
    Optional<UserEntity> findByOidcId(String id);
}


