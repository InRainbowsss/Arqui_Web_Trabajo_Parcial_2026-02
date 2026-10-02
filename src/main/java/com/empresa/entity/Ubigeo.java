package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ubigeo")
public class Ubigeo {

    @Id
    @Column(name = "idUbigeo")
    private Integer idUbigeo;

    @Column(length = 45)
    private String departamento;

    @Column(length = 45)
    private String provincia;

    @Column(length = 45)
    private String distrito;
}
