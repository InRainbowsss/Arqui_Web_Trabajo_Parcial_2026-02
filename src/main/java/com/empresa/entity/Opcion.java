package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "opcion")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpcion")
    private Integer idOpcion;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String estado;

    @Column(columnDefinition = "TEXT")
    private String ruta;

    private Short tipo;
}
