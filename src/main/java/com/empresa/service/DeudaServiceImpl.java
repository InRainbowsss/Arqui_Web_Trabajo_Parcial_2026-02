package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Deuda;
import com.empresa.repository.DeudaRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class DeudaServiceImpl implements DeudaService {
    private final DeudaRepository repository;
    
    @Override public List<Deuda> listarTodos() { return repository.findAll(); }
    @Override public Deuda guardar(Deuda obj) { return repository.save(obj); }
    @Override public Deuda actualizar(Integer id, Deuda obj) { obj.setIdDeuda(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}