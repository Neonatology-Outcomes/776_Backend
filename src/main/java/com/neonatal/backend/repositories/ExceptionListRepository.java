package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Exceptionlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface functions as the class for CRUD operations
 * on the Exceptionlist table with ID type of Long.
 */
@Repository
public interface ExceptionListRepository extends JpaRepository<Exceptionlist, Long> {
}
