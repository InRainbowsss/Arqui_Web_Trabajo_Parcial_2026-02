package com.empresa.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ConsolidacionRequestDTO {
    private Integer idUsuario;
    private List<Integer> idsDeudasAProcesar;
    private Integer nuevoPlazoMeses;
    private java.math.BigDecimal ingresoMensualDeclarado; // Para validar la viabilidad
    private Integer idDataCatalogoRefinanciacion; // ID del catálogo que define la refinanciación
}