package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.RecursoEducativo;
import com.empresa.service.RecursoEducativoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recursoeducativo")
@RequiredArgsConstructor
public class RecursoEducativoController {

	private final RecursoEducativoService recursoEducativoService;
	
	@GetMapping
	public List<RecursoEducativo> listaTodos(){
		return recursoEducativoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<RecursoEducativo> guardar(@RequestBody RecursoEducativo obj) {
		RecursoEducativo objRegistrado = recursoEducativoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<RecursoEducativo> actualizar(@PathVariable Integer id, @RequestBody RecursoEducativo obj) {
        try {
        	RecursoEducativo objActualizado = recursoEducativoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	recursoEducativoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}