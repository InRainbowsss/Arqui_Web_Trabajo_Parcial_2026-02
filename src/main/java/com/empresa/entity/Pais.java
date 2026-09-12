package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPais")
    private Integer idPais;

    @Column(length = 2)
    private String iso;

    @Column(length = 80)
    private String nombre;
}
