package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Criteria_Bundles;
import com.neonatal.backend.entities.Recommendation_Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the Recommendation_Bundle table with ID type of BigInteger
 */
@Repository
public interface RecommendationBundleRepository extends JpaRepository<Recommendation_Bundle, Long> {

    @Query(value = "SELECT * FROM quality.recommendation_bundle WHERE sub_bundle_id = :id", nativeQuery = true)
    public List<Recommendation_Bundle> getBySub_bundle_id (Long id);

}
