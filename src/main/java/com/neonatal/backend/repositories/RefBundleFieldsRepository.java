package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Ref_Bundle_Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the BRef_Bundle_Fields table with ID type of Integer
 */
@Repository
public interface RefBundleFieldsRepository extends JpaRepository<Ref_Bundle_Fields, Integer> {
}
