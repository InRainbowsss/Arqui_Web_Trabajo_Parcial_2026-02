package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Deuda;
import com.empresa.service.DeudaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/deuda")
@RequiredArgsConstructor
public class DeudaController {

	private final DeudaService deudaService;
	
	@GetMapping
	public List<Deuda> listaTodos(){
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
}