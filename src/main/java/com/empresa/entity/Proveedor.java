package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private Integer idProveedor;

    @Column(name = "razonSocial", length = 100)
    private String razonSocial;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;
}
