package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *This interface functions as the class for CRUD operations
 * on the User table with ID type of Long.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Query the database to retrieve the roleid of the passed username
    @Query(value = "SELECT roleid FROM quality.user WHERE username = :username", nativeQuery = true)
    public String getRoleidByUsername (String username);
    
    @Query(value = "SELECT username FROM quality.user WHERE username = :username", nativeQuery = true)
    public String getUsernameByUsername (String username);
    
    @Query(value = "SELECT password FROM quality.user WHERE username = :username", nativeQuery = true)
    public String getPasswordByUsername (String username);
    
    @Query(value = "SELECT emailaddress FROM quality.user WHERE username = :username", nativeQuery = true)
    public String getEmailByUsername (String username);
    
    @Query(value = "SELECT password FROM quality.user WHERE emailaddress = :emailaddress", nativeQuery = true)
    public String getPasswordByEmail (String emailaddress);
}
