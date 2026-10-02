package com.empresa.repository;

import com.empresa.entity.UsuarioHasRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioHasRolRepository extends JpaRepository<UsuarioHasRol, Integer> {
    // JpaRepository ya incluye operaciones CRUD básicas como save, findAll, findById, delete, etc.
}