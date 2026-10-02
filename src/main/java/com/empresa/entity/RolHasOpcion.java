package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rol_has_opcion")
public class RolHasOpcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRolOpcion") // ID simple autoincremental
    private Integer idRolOpcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idrol")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idopcion")
    private Opcion opcion;
}