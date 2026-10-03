package com.empresa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.empresa.dto.GastoFiltroRequestDTO;
import com.empresa.dto.GastoReporteResponseDTO;
import com.empresa.entity.CategoriaGasto;
import com.empresa.entity.Gasto;
import com.empresa.repository.CategoriaGastoRepository;
import com.empresa.repository.GastoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;
    private final CategoriaGastoRepository categoriaGastoRepository;

    @Override
    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    @Override
    public Gasto guardar(Gasto obj) {
        return gastoRepository.save(obj);
    }

    @Override
    public Gasto actualizar(Integer id, Gasto obj) {
        obj.setIdGasto(id);
        return gastoRepository.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        gastoRepository.deleteById(id);
    }

    // --- LÓGICA DE LA HU-A: REPORTE DE GASTOS FILTRADOS ---
    @Override
    public GastoReporteResponseDTO obtenerReporteGastosFiltrados(GastoFiltroRequestDTO request) {
        
        // 1. Validación de fechas (Criterio de aceptación 2: Fecha inicio no mayor a fecha fin)
        if (request.getFechaInicio() != null && request.getFechaFin() != null) {
            if (request.getFechaInicio().isAfter(request.getFechaFin())) {
                throw new RuntimeException("Error de validación: La fecha de inicio no puede ser posterior a la fecha de fin.");
            }
        }

        // 2. Obtener la categoría de gasto para conocer su presupuesto límite
        CategoriaGasto categoria = categoriaGastoRepository.findById(request.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría de gasto no encontrada."));

        // 3. Buscar los gastos usando el repositorio con fechas y categoría
        List<Gasto> gastosEncontrados = gastoRepository.findByCategoriaAndRangoFechas(
                request.getIdCategoria(), 
                request.getFechaInicio(), 
                request.getFechaFin()
        );

        // 4. Calcular el monto total gastado usando Streams de Java
        BigDecimal totalGastado = gastosEncontrados.stream()
                .map(Gasto::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal limite = categoria.getLimiteGasto() != null ? categoria.getLimiteGasto() : BigDecimal.ZERO;

        // 5. Calcular el porcentaje consumido respecto al límite
        BigDecimal porcentaje = BigDecimal.ZERO;
        if (limite.compareTo(BigDecimal.ZERO) > 0) {
            porcentaje = totalGastado.multiply(BigDecimal.valueOf(100))
                                      .divide(limite, 2, RoundingMode.HALF_UP);
        }

        // 6. Generar mensaje de alerta según el consumo
        String alerta = "Presupuesto bajo control.";
        if (porcentaje.compareTo(BigDecimal.valueOf(100)) > 0) {
            alerta = "¡Alerta! Ha sobrepasado el 100% del límite de su presupuesto.";
        } else if (porcentaje.compareTo(BigDecimal.valueOf(80)) >= 0) {
            alerta = "¡Precaución! Ha alcanzado o superado el 80% de su presupuesto.";
        }

        // 7. Mapear la lista de detalles para el DTO
        List<GastoReporteResponseDTO.GastoDetalleDTO> detalleDTOs = gastosEncontrados.stream().map(g -> {
            GastoReporteResponseDTO.GastoDetalleDTO det = new GastoReporteResponseDTO.GastoDetalleDTO();
            det.setIdGasto(g.getIdGasto());
            det.setDescripcion(g.getDescripcion());
            det.setMonto(g.getMonto());
            det.setFechaGasto(g.getFechaGasto());
            return det;
        }).collect(Collectors.toList());

        // 8. Construir el DTO de respuesta final
        GastoReporteResponseDTO response = new GastoReporteResponseDTO();
        response.setNombreCategoria(categoria.getNombre());
        response.setLimitePresupuesto(limite);
        response.setTotalGastado(totalGastado);
        response.setPorcentajeConsumido(porcentaje);
        response.setMensajeAlerta(alerta);
        response.setDetalleGastos(detalleDTOs);

        return response;
    }
}