package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the User table with ID type of BigInteger
 */
@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
}
