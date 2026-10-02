package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.UsuarioHasRol;
import com.empresa.service.UsuarioHasRolService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuariohasrol")
@RequiredArgsConstructor
public class UsuarioHasRolController {

	private final UsuarioHasRolService usuarioHasRolService;
	
	@GetMapping
	public List<UsuarioHasRol> listaTodos(){
		return usuarioHasRolService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<UsuarioHasRol> guardar(@RequestBody UsuarioHasRol obj) {
		UsuarioHasRol objRegistrado = usuarioHasRolService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<UsuarioHasRol> actualizar(@PathVariable Integer id, @RequestBody UsuarioHasRol obj) {
        try {
        	UsuarioHasRol objActualizado = usuarioHasRolService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	usuarioHasRolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}