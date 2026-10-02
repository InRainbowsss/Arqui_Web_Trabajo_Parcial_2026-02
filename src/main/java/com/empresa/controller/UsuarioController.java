package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Usuario;
import com.empresa.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> listaTodos(){
		return usuarioService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario obj) {
		Usuario objRegistrado = usuarioService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario obj) {
        try {
        	Usuario objActualizado = usuarioService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}