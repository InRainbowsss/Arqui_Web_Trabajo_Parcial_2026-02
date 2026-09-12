package com.empresa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "datacatalogo")
public class DataCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDataCatalogo")
    private Integer idDataCatalogo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 45)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCatalogo", nullable = false)
    private Catalogo catalogo;
}
