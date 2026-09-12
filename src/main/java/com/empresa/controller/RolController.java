package com.empresa.controller;

import com.empresa.entity.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/rol")
public class RolController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<Rol>> listaRol() {
        List<Rol> lista = entityManager.createQuery("FROM Rol", Rol.class).getResultList();
        return ResponseEntity.ok(lista);
    }
}