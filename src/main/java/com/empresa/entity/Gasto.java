package com.empresa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gasto")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGasto")
    private Integer idGasto;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_gasto", nullable = false)
    private LocalDate fechaGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    private CategoriaGasto categoriaGasto;

    @Column(name = "estado", nullable = false, length = 45)
    private String estado;

    @Column(name = "usuario_creado")
    private Integer usuarioCreado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_actualizado")
    private Integer usuarioActualizado;

    @Column(name = "fecha_actualizada")
    private LocalDateTime fechaActualizada;
}