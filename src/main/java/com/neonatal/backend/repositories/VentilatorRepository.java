package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Ventilator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Ventilator table with ID type of long.
 */
@Repository
public interface VentilatorRepository extends JpaRepository<Ventilator, Long>{
    @Query(value = "SELECT * FROM quality.ventilator WHERE ventilator_id = :id", nativeQuery = true)
    public List<Ventilator> getByVentilator_id (Long id);

    @Query(value = "SELECT * FROM quality.ventilator WHERE uhid = :uhid", nativeQuery = true)
    public List<Ventilator> getVentilatorByUHID (String uhid);
}
