package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(length = 100)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    @Column(length = 15)
    private String login;

    @Column(length = 200)
    private String password;

    @Column(length = 45)
    private String correo;

    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuario_has_rol",
        joinColumns = @JoinColumn(name = "idUsuario"),
        inverseJoinColumns = @JoinColumn(name = "idRol")
    )
    private List<Rol> roles;
}
