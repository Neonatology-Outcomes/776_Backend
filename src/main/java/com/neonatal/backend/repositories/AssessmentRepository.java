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
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    @Query(value = "SELECT * FROM quality.assessment WHERE assessment_id = :id", nativeQuery = true)
    public List<Assessment> getByAssessment_id(Long id);

}
