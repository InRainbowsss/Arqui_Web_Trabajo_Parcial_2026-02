package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.DataCatalogo;
import com.empresa.service.DataCatalogoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/datacatalogo")
@RequiredArgsConstructor
public class DataCatalogoController {

	private final DataCatalogoService dataCatalogoService;
	
	@GetMapping
	public List<DataCatalogo> listaTodos(){
		return dataCatalogoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<DataCatalogo> guardar(@RequestBody DataCatalogo obj) {
		DataCatalogo objRegistrado = dataCatalogoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<DataCatalogo> actualizar(@PathVariable Integer id, @RequestBody DataCatalogo obj) {
        try {
        	DataCatalogo objActualizado = dataCatalogoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	dataCatalogoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}