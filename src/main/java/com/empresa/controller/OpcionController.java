package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Opcion;
import com.empresa.service.OpcionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/opcion")
@RequiredArgsConstructor
public class OpcionController {

	private final OpcionService opcionService;
	
	@GetMapping
	public List<Opcion> listaTodos(){
		return opcionService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Opcion> guardar(@RequestBody Opcion obj) {
		Opcion objRegistrado = opcionService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Opcion> actualizar(@PathVariable Integer id, @RequestBody Opcion obj) {
        try {
        	Opcion objActualizado = opcionService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	opcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}