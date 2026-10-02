package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Gasto;
import com.empresa.service.GastoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/gasto")
@RequiredArgsConstructor
public class GastoController {

	private final GastoService gastoService;
	
	@GetMapping
	public List<Gasto> listaTodos(){
		return gastoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Gasto> guardar(@RequestBody Gasto obj) {
		Gasto objRegistrado = gastoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizar(@PathVariable Integer id, @RequestBody Gasto obj) {
        try {
        	Gasto objActualizado = gastoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	gastoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}