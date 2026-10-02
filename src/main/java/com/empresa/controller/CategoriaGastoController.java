package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.CategoriaGasto;
import com.empresa.service.CategoriaGastoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categoriagasto")
@RequiredArgsConstructor
public class CategoriaGastoController {

	private final CategoriaGastoService categoriaGastoService;
	
	@GetMapping
	public List<CategoriaGasto> listaTodos(){
		return categoriaGastoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaGasto> guardar(@RequestBody CategoriaGasto obj) {
		CategoriaGasto objRegistrado = categoriaGastoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<CategoriaGasto> actualizar(@PathVariable Integer id, @RequestBody CategoriaGasto obj) {
        try {
        	CategoriaGasto objActualizado = categoriaGastoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	categoriaGastoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}