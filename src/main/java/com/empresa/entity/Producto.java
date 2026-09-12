package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    private DataCatalogo categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;
}
