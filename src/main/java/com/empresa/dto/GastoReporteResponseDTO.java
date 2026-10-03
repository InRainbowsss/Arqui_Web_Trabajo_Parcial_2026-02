package com.empresa.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GastoReporteResponseDTO {
    private String nombreCategoria;
    private BigDecimal limitePresupuesto;
    private BigDecimal totalGastado;
    private BigDecimal porcentajeConsumido;
    private String mensajeAlerta;
    private List<GastoDetalleDTO> detalleGastos;

    @Getter
    @Setter
    public static class GastoDetalleDTO {
        private Integer idGasto;
        private String descripcion;
        private BigDecimal monto;
        private LocalDate fechaGasto;
    }
}