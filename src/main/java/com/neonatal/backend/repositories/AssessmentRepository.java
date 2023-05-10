package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Assessment;
import com.neonatal.backend.entities.Criteria_Bundles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Assessment table with ID type of long.
 */
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    @Query(value = "SELECT DISTINCT uhid FROM quality.assessment ORDER BY uhid ASC", nativeQuery = true)
    public List<String> getUniqueUhid();

    @Query(value = "SELECT * FROM quality.assessment WHERE uhid = :uhid", nativeQuery = true)
    public List<Assessment> getByUhid(String uhid);

    @Query(value = "SELECT * FROM quality.assessment WHERE uhid = :uhid AND EXTRACT(year from entrytimestamp) = :year AND EXTRACT(month from entrytimestamp) = :month AND EXTRACT(day from entrytimestamp) = :day", nativeQuery = true)
    public List<Assessment> getByUhidDate(String uhid, int year, int month, int day);

    @Query(value = "SELECT uhid FROM quality.assessment WHERE EXTRACT(year from entrytimestamp) = :year AND EXTRACT(month from entrytimestamp) = :month AND EXTRACT(day from entrytimestamp) = :day", nativeQuery = true)
    public List<String> getUhidByDate(int year, int month, int day);

}
