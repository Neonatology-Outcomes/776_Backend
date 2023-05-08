package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Assessment table with ID type of long.
 */
@Repository
public interface MiscRepository extends JpaRepository<List<Long>, Long> {

    @Query(value = "SELECT DISTINCT uhid FROM :tableNames WHERE :whereClause", nativeQuery = true)
    public List<Long> implementRule(String tableNames, String whereClause);

    @Query(value = "SELECT * FROM quality.assessment WHERE uhid = :uhid", nativeQuery = true)
    public List<Assessment> getByUhid(String uhid);


}
