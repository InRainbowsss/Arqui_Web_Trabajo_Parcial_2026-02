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
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private Integer idPago;

    @Column(name = "monto", nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Column(name = "cuota")
    private Integer cuota;
    
    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDeuda", nullable = false)
    private Deuda deuda;

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