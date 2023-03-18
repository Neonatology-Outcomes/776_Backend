package com.neonatal.backend.rules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Rules Design on the front-end.  Allows DAO to the database table "rules"
 */
@Repository
public interface RulesRepository extends JpaRepository<Rule, Integer> {

    /*
    @Query(value = "SELECT * FROM rules where id = :id", nativeQuery = true)
    public List<Rule> getID (Long id);
    */


    // Fill the rest with the needed function calls here.
}
