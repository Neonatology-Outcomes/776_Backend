package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Recommendation_Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the Recommendation_Bundle table with ID type of BigInteger
 */
@Repository
public interface RecommendationBundleRepository extends JpaRepository<Recommendation_Bundle, BigInteger> {
}
