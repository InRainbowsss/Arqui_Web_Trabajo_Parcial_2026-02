package com.empresa.repository;

import com.empresa.entity.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Integer> {
    // Hereda todas las operaciones CRUD estándar automáticamente
}