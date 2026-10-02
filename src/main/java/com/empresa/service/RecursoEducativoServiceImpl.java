package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.RecursoEducativo;
import com.empresa.repository.RecursoEducativoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class RecursoEducativoServiceImpl implements RecursoEducativoService {
    private final RecursoEducativoRepository repository;
    
    @Override public List<RecursoEducativo> listarTodos() { return repository.findAll(); }
    @Override public RecursoEducativo guardar(RecursoEducativo obj) { return repository.save(obj); }
    @Override public RecursoEducativo actualizar(Integer id, RecursoEducativo obj) { obj.setIdRecurso(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}