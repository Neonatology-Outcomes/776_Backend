package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Sub_Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * This interface functions as the class for CRUD operations
 * on the Sub_Bundle table with ID type of Long.
 */
@Repository
public interface SubBundle_Repository extends JpaRepository<Sub_Bundle, Long> {
}
