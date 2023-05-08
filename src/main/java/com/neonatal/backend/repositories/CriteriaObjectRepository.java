package com.neonatal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neonatal.backend.entities.Criteria_Object;

/**
 * This interface functions as the class for CRUD operations
 * on the Criteria_Object table with ID type of Long.
 */
@Repository
public interface CriteriaObjectRepository extends JpaRepository<Criteria_Object, Long> {

    @Query(value = "SELECT * FROM quality.criteria_object WHERE criteria_bundles_id = :id", nativeQuery = true)
    public List<Criteria_Object> getByCriteria_bundles_id (Long id);
    
    @Query(value = "SELECT * FROM quality.criteria_object", nativeQuery = true)
    public List<Criteria_Object> getByCriteria_bundles();

}
