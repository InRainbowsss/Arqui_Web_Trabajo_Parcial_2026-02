package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Ubigeo;
import com.empresa.service.UbigeoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ubigeo")
@RequiredArgsConstructor
public class UbigeoController {

	private final UbigeoService ubigeoService;
	
	@GetMapping
	public List<Ubigeo> listaTodos(){
		return ubigeoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Ubigeo> guardar(@RequestBody Ubigeo obj) {
		Ubigeo objRegistrado = ubigeoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Ubigeo> actualizar(@PathVariable Integer id, @RequestBody Ubigeo obj) {
        try {
        	Ubigeo objActualizado = ubigeoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	ubigeoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}