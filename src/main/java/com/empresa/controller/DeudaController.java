package com.empresa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.ConsolidacionRequestDTO;
import com.empresa.dto.DeudaConsolidadaResponseDTO;
import com.empresa.entity.Deuda;
import com.empresa.service.DeudaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/deuda")
@RequiredArgsConstructor
public class DeudaController {

    private final DeudaService deudaService;
    
    // --- CRUD TRADICIONAL ---
    
    @GetMapping
    public List<Deuda> listaTodos() {
        return deudaService.listarTodos();
    }
    
    @PostMapping
    public ResponseEntity<Deuda> guardar(@RequestBody Deuda obj) {
        Deuda objRegistrado = deudaService.guardar(obj);
        return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Deuda> actualizar(@PathVariable Integer id, @RequestBody Deuda obj) {
        try {
            Deuda objActualizado = deudaService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        deudaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // --- NUEVO ENDPOINT PARA LA HU-01 (CONSOLIDACIÓN DE DEUDAS) ---
    @PostMapping("/consolidar")
    public ResponseEntity<DeudaConsolidadaResponseDTO> consolidarDeudas(@RequestBody ConsolidacionRequestDTO request) {
        try {
            DeudaConsolidadaResponseDTO resultado = deudaService.consolidarDeudas(request);
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Retorna un HTTP 422 (Unprocessable Entity) si falla alguna validación de negocio (ej. viabilidad o listas vacías)
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
}