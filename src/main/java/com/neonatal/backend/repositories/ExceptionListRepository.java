package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Exceptionlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the Exceptionlist table with ID type of Integer
 */
@Repository
public interface ExceptionListRepository extends JpaRepository<Exceptionlist, Long> {
}
