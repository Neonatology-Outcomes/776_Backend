package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Ref_Bundle_Master_Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the Ref_Bundle_Master_Values table with ID type of Integer
 */
@Repository
public interface RefBundleMasterValuesRepository extends JpaRepository<Ref_Bundle_Master_Values, Integer> {
}
