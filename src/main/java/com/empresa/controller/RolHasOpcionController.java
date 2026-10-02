package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.RolHasOpcion;
import com.empresa.service.RolHasOpcionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rolhasopcion")
@RequiredArgsConstructor
public class RolHasOpcionController {

	private final RolHasOpcionService rolHasOpcionService;
	
	@GetMapping
	public List<RolHasOpcion> listaTodos(){
		return rolHasOpcionService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<RolHasOpcion> guardar(@RequestBody RolHasOpcion obj) {
		RolHasOpcion objRegistrado = rolHasOpcionService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<RolHasOpcion> actualizar(@PathVariable Integer id, @RequestBody RolHasOpcion obj) {
        try {
        	RolHasOpcion objActualizado = rolHasOpcionService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	rolHasOpcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}