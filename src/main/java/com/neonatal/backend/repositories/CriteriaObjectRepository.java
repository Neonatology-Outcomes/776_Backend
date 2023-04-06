package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Criteria_Bundles;
import com.neonatal.backend.entities.Criteria_Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Repository interface for the Assessment table.  This interface functions as the class for CRUD operations
 * on the Criteria_Object table with ID type of BigInteger
 */
@Repository
public interface CriteriaObjectRepository extends JpaRepository<Criteria_Object, Long> {

    @Query(value = "SELECT * FROM quality.criteria_object WHERE criteria_bundles_id = :id", nativeQuery = true)
    public List<Criteria_Object> getByCriteria_bundles_id (Long id);

}
