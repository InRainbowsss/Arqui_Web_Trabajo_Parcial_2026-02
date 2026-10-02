package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Pago;
import com.empresa.repository.PagoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {
    private final PagoRepository repository;
    
    @Override public List<Pago> listarTodos() { return repository.findAll(); }
    @Override public Pago guardar(Pago obj) { return repository.save(obj); }
    @Override public Pago actualizar(Integer id, Pago obj) { obj.setIdPago(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}