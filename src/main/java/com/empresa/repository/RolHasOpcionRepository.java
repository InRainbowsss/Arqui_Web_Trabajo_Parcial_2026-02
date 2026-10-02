package com.empresa.repository;

import com.empresa.entity.RolHasOpcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolHasOpcionRepository extends JpaRepository<RolHasOpcion, Integer> {
    // JpaRepository ya incluye operaciones CRUD básicas como save, findAll, findById, delete, etc.
}