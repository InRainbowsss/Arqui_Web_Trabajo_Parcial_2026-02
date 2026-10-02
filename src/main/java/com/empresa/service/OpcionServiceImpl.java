package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Opcion;
import com.empresa.repository.OpcionRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class OpcionServiceImpl implements OpcionService {
    private final OpcionRepository repository;
    
    @Override public List<Opcion> listarTodos() { return repository.findAll(); }
    @Override public Opcion guardar(Opcion obj) { return repository.save(obj); }
    @Override public Opcion actualizar(Integer id, Opcion obj) { obj.setIdOpcion(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}