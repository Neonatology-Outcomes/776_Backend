package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Ref_Bundle_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * This interface functions as the class for CRUD operations
 * on the Ref_Bundle_Category table with ID type of Long.
 */
@Repository
public interface RefBundleCategoryRepository extends JpaRepository<Ref_Bundle_Category, Long> {
}
