package com.empresa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria_gasto")
public class CategoriaGasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Integer idCategoria;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "limite_gasto", nullable = false, precision = 10, scale = 2)
    private BigDecimal limiteGasto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

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