package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Medication table with ID type of long.
 */
@Repository
public interface MedicationRepository extends JpaRepository <Medication, Long>{
    @Query(value = "SELECT * FROM quality.medication WHERE medication_id = :id", nativeQuery = true)
    public List<Medication> getByMedication_id (Long id);

    @Query(value = "SELECT * FROM quality.medication WHERE uhid = :uhid", nativeQuery = true)
    public List<Medication> getMedicationByUHID (String uhid);
}
