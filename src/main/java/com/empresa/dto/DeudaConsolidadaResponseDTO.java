package com.empresa.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class DeudaConsolidadaResponseDTO {
    private Integer idNuevaDeudaUnificada;
    private BigDecimal montoTotalConsolidado;
    private BigDecimal nuevaTasaInteresPonderada;
    private BigDecimal cuotaMensualProyectada;
    private Integer nuevoPlazoMeses;
    private String mensaje;
}