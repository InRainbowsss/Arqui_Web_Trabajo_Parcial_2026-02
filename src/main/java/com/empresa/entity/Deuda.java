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
@Table(name = "deuda")
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeuda")
    private Integer idDeuda;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "monto", nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Column(name = "tasa_interes", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDataCatalogo", nullable = false)
    private DataCatalogo dataCatalogo;

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