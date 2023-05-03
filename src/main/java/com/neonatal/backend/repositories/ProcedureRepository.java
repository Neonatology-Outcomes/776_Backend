package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface functions as the class for CRUD operations
 * on the Procedure table with ID type of long.
 */
@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long>{
    @Query(value = "SELECT * FROM quality.procedure WHERE procedure_id = :id", nativeQuery = true)
    public List<Procedure> getByProcedure_id (Long id);

    @Query(value = "SELECT * FROM quality.procedure WHERE uhid = :uhid", nativeQuery = true)
    public List<Procedure> getProcedureByUHID (String uhid);

}
