package com.empresa.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.empresa.entity.Pago;
import com.empresa.service.PagoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pago")
@RequiredArgsConstructor
public class PagoController {

	private final PagoService pagoService;
	
	@GetMapping
	public List<Pago> listaTodos(){
		return pagoService.listarTodos();
	}
	
	@PostMapping
	public ResponseEntity<Pago> guardar(@RequestBody Pago obj) {
		Pago objRegistrado = pagoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @RequestBody Pago obj) {
        try {
        	Pago objActualizado = pagoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}