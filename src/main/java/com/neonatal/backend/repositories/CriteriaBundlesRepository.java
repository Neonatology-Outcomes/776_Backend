package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Criteria_Bundles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Criteria_Bundles table with ID type of long.
 */
@Repository
public interface CriteriaBundlesRepository extends JpaRepository<Criteria_Bundles, Long> {

    @Query(value = "SELECT * FROM quality.criteria_bundles WHERE sub_bundle_id = :id", nativeQuery = true)
    public List<Criteria_Bundles> getBySub_bundle_id (Long id);

}
