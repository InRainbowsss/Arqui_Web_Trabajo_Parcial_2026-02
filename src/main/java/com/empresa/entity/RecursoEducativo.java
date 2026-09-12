package com.empresa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recurso_educativo")
public class RecursoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecurso")
    private Integer idRecurso;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "url", nullable = false, columnDefinition = "TEXT")
    private String url;

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