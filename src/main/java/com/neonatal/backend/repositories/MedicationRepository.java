package com.neonatal.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neonatal.backend.entities.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    // Query the database to retrieve the roleid of the passed username
    @Query(value = "SELECT * FROM quality.medication WHERE uhid = :uhid", nativeQuery = true)
    public String getMedicationByUhid (String uhid);
}