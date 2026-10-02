package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Catalogo;
import com.empresa.service.CatalogoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/catalogo")
@RequiredArgsConstructor
public class CatalogoController {

	private final CatalogoService catalogoService;
	
	@GetMapping
	public List<Catalogo> listaTodos(){
		return catalogoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Catalogo> guardar(@RequestBody Catalogo obj) {
		Catalogo objRegistrado = catalogoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Catalogo> actualizar(@PathVariable Integer id, @RequestBody Catalogo obj) {
        try {
        	Catalogo objActualizado = catalogoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	catalogoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}