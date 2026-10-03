package com.empresa.service;

import com.empresa.dto.GastoFiltroRequestDTO;
import com.empresa.dto.GastoReporteResponseDTO;
import com.empresa.entity.Gasto;
import java.util.List;

public interface GastoService {
    List<Gasto> listarTodos();
    Gasto guardar(Gasto obj);
    Gasto actualizar(Integer id, Gasto obj);
    void eliminar(Integer id);
    
    // Método para la HU-A
    GastoReporteResponseDTO obtenerReporteGastosFiltrados(GastoFiltroRequestDTO request);
}