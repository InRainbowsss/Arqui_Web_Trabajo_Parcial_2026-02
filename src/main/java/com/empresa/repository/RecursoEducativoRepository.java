package com.empresa.repository;

import com.empresa.entity.RecursoEducativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoEducativoRepository extends JpaRepository<RecursoEducativo, Integer> {
}