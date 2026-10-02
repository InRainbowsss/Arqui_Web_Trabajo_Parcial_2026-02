package com.empresa.repository;

import com.empresa.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    // Hereda todas las operaciones CRUD estándar automáticamente
}