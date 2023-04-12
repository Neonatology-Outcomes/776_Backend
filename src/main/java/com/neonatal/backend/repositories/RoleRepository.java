package com.neonatal.backend.repositories;

import com.neonatal.backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface functions as the class for CRUD operations
 * on the Role table with ID type of Long.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
