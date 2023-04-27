package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Criteria_Object;
import com.neonatal.backend.entities.Recommendation_Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Recommendation_Object table with ID type of Long.
 */
@Repository
public interface RecommendationObjectRepository extends JpaRepository<Recommendation_Object, Long> {

    @Query(value = "SELECT * FROM quality.recommendation_object WHERE recommendation_bundle_id = :id", nativeQuery = true)
    public List<Recommendation_Object> getByRecommendation_object_id(Long id);
    
    @Query(value = "SELECT * FROM quality.recommendation_object", nativeQuery = true)
    public List<Recommendation_Object> getAllRecommendations();

}
