package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "catalogo")
public class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatalogo")
    private Integer idCatalogo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 45)
    private String estado;
}
