package com.empresa.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.empresa.entity.Gasto;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {

    // Consulta personalizada para la HU-A
    @Query("SELECT g FROM Gasto g WHERE g.categoriaGasto.idCategoria = :idCategoria AND g.fechaGasto BETWEEN :fechaInicio AND :fechaFin")
    List<Gasto> findByCategoriaAndRangoFechas(
        @Param("idCategoria") Integer idCategoria,
        @Param("fechaInicio") LocalDate fechaInicio,
        @Param("fechaFin") LocalDate fechaFin
    );
}