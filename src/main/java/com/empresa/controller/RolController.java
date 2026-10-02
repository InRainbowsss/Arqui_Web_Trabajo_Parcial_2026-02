package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Rol;
import com.empresa.service.RolService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class RolController {

	private final RolService rolService;
	
	@GetMapping
	public List<Rol> listaTodos(){
		return rolService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Rol> guardar(@RequestBody Rol obj) {
		Rol objRegistrado = rolService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol obj) {
        try {
        	Rol objActualizado = rolService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}