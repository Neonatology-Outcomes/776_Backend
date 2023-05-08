package com.neonatal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neonatal.backend.entities.Ventilator;

@Repository
public interface VentilatorRepository extends JpaRepository<Ventilator, Long> {

    // Query the database to retrieve the roleid of the passed username
    @Query(value = "SELECT * FROM quality.ventilator WHERE uhid = :uhid", nativeQuery = true)
    public List<Ventilator> getVentilatorByUhid (String uhid);
    
    @Query(value = "SELECT * FROM quality.ventilator WHERE uhid = :uhid and vent_mode = :vent", nativeQuery = true)
    public List<Ventilator> getVentilatorByUhidAndMode (String uhid, String vent);
}