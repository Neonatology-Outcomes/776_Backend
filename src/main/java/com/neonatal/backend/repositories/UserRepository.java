package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the User table with ID type of BigInteger
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Query the databse to see if there is a username by the name of the username parameter
    @Query(value = "SELECT * FROM quality.user WHERE username = :username", nativeQuery = true)
    public List<User> getByUsername (String username);
}
