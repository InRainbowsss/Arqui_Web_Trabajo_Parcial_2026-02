package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;

    @Column(length = 45)
    private String nombre;

    @Column(length = 45)
    private String estado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rol_has_opcion",
        joinColumns = @JoinColumn(name = "idrol"),
        inverseJoinColumns = @JoinColumn(name = "idopcion")
    )
    private List<Opcion> opciones;
}
