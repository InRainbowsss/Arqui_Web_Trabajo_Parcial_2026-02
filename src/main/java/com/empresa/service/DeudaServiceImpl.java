package com.empresa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.dto.ConsolidacionRequestDTO;
import com.empresa.dto.DeudaConsolidadaResponseDTO;
import com.empresa.entity.DataCatalogo;
import com.empresa.entity.Deuda;
import com.empresa.entity.Pago;
import com.empresa.entity.Usuario;
import com.empresa.repository.DataCatalogoRepository;
import com.empresa.repository.DeudaRepository;
import com.empresa.repository.PagoRepository;
import com.empresa.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class DeudaServiceImpl implements DeudaService {

    private final DeudaRepository repository;
    private final PagoRepository pagoRepository;
    private final UsuarioRepository usuarioRepository;
    private final DataCatalogoRepository dataCatalogoRepository;
    
    @Override 
    public List<Deuda> listarTodos() { 
        return repository.findAll(); 
    }
    
    @Override 
    public Deuda guardar(Deuda obj) { 
        return repository.save(obj); 
    }
    
    @Override 
    public Deuda actualizar(Integer id, Deuda obj) { 
        obj.setIdDeuda(id); 
        return repository.save(obj); 
    }
    
    @Override 
    public void eliminar(Integer id) { 
        repository.deleteById(id); 
    }

    // --- LÓGICA DE LA HU-01 SIMPLIFICADA CON STREAMS Y MÉTODOS AUXILIARES ---
    @Override
    @Transactional
    public DeudaConsolidadaResponseDTO consolidarDeudas(ConsolidacionRequestDTO request) {
        
        // 1. Validar y obtener deudas origen
        List<Deuda> deudasOrigen = validarYObtenerDeudas(request.getIdsDeudasAProcesar());

        // 2. Calcular montos y tasa ponderada usando Streams de Java
        BigDecimal montoTotal = calcularMontoTotal(deudasOrigen);
        BigDecimal tasaPonderada = calcularTasaPonderada(deudasOrigen, montoTotal);

        // 3. Calcular cuota mensual (Sistema Francés)
        int meses = (request.getNuevoPlazoMeses() != null && request.getNuevoPlazoMeses() > 0) ? request.getNuevoPlazoMeses() : 12;
        BigDecimal cuotaMensual = calcularCuotaMensual(montoTotal, tasaPonderada, meses);

        // 4. Validar viabilidad financiera (máximo 40% de ingresos)
        validarViabilidad(request.getIngresoMensualDeclarado(), cuotaMensual);

        // 5. Actualizar estado de deudas originales a "Consolidada/Refinanciada"
        deudasOrigen.forEach(d -> {
            d.setEstado("Consolidada/Refinanciada");
            repository.save(d);
        });

        // 6. Obtener relaciones y registrar la nueva deuda unificada
        Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                
        DataCatalogo dataCatalogo = dataCatalogoRepository.findById(request.getIdDataCatalogoRefinanciacion())
                .orElseThrow(() -> new RuntimeException("Data Catálogo de refinanciación no encontrado"));

        Deuda nuevaDeuda = registrarNuevaDeudaUnificada(montoTotal, tasaPonderada, meses, usuario, dataCatalogo);

        // 7. Generar cronograma automático de pagos
        generarCronogramaPagos(nuevaDeuda, cuotaMensual, meses);

        // 8. Retornar DTO de respuesta
        DeudaConsolidadaResponseDTO response = new DeudaConsolidadaResponseDTO();
        response.setIdNuevaDeudaUnificada(nuevaDeuda.getIdDeuda());
        response.setMontoTotalConsolidado(montoTotal);
        response.setNuevaTasaInteresPonderada(tasaPonderada);
        response.setCuotaMensualProyectada(cuotaMensual);
        response.setNuevoPlazoMeses(meses);
        response.setMensaje("Consolidación realizada de forma óptima.");

        return response;
    }

    // --- MÉTODOS AUXILIARES PRIVADOS PARA MANTENER EL CÓDIGO LIMPIO ---

    private List<Deuda> validarYObtenerDeudas(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new RuntimeException("Debe seleccionar al menos una deuda.");
        }
        List<Deuda> deudas = repository.findAllById(ids);
        if (deudas.isEmpty()) {
            throw new RuntimeException("No se encontraron deudas válidas.");
        }
        return deudas;
    }

    private BigDecimal calcularMontoTotal(List<Deuda> deudas) {
        return deudas.stream()
                .map(Deuda::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularTasaPonderada(List<Deuda> deudas, BigDecimal montoTotal) {
        if (montoTotal.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO;
        
        BigDecimal sumaPonderadores = deudas.stream()
                .map(d -> d.getMonto().multiply(d.getTasaInteres() != null ? d.getTasaInteres() : BigDecimal.ZERO))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sumaPonderadores.divide(montoTotal, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularCuotaMensual(BigDecimal monto, BigDecimal tasaAnual, int meses) {
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP)
                                           .divide(BigDecimal.valueOf(12), 4, RoundingMode.HALF_UP);
        if (tasaMensual.compareTo(BigDecimal.ZERO) == 0) {
            return monto.divide(BigDecimal.valueOf(meses), 2, RoundingMode.HALF_UP);
        }
        double i = tasaMensual.doubleValue();
        double factor = Math.pow(1 + i, meses);
        double cuotaDouble = monto.doubleValue() * (i * factor) / (factor - 1);
        return BigDecimal.valueOf(cuotaDouble).setScale(2, RoundingMode.HALF_UP);
    }

    private void validarViabilidad(BigDecimal ingreso, BigDecimal cuota) {
        if (ingreso != null) {
            BigDecimal limite = ingreso.multiply(BigDecimal.valueOf(0.40));
            if (cuota.compareTo(limite) > 0) {
                throw new RuntimeException("Operación denegada: La cuota excede el 40% de los ingresos declarados.");
            }
        }
    }

    private Deuda registrarNuevaDeudaUnificada(BigDecimal monto, BigDecimal tasa, int meses, Usuario u, DataCatalogo dc) {
        Deuda deuda = new Deuda();
        deuda.setDescripcion("Deuda Unificada por Consolidación");
        deuda.setMonto(monto);
        deuda.setCuotas(meses);
        deuda.setTasaInteres(tasa);
        deuda.setFechaVencimiento(LocalDate.now().plusMonths(meses));
        deuda.setEstado("Activo");
        deuda.setUsuario(u);
        deuda.setDataCatalogo(dc);
        return repository.save(deuda);
    }

    private void generarCronogramaPagos(Deuda deuda, BigDecimal cuota, int meses) {
        for (int c = 1; c <= meses; c++) {
            Pago pago = new Pago();
            pago.setMonto(cuota);
            pago.setCuota(c);
            pago.setFechaPago(LocalDate.now().plusMonths(c));
            pago.setEstado("Pendiente");
            pago.setDeuda(deuda);
            pagoRepository.save(pago);
        }
    }
}