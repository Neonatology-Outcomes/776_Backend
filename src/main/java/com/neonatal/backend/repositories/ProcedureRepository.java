package com.neonatal.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neonatal.backend.entities.Procedure;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {

    // Query the database to retrieve the roleid of the passed username
    @Query(value = "SELECT * FROM quality.procedure WHERE uhid = :uhid", nativeQuery = true)
    public List<Procedure> getProcedureByUhid (String uhid);
    
    @Query(value = "SELECT * FROM quality.procedure WHERE uhid = :uhid and procedure_type = :procedure", nativeQuery = true)
    public List<Procedure> getPreocedureByUhidAndProcedure (String uhid, String procedure);
}
