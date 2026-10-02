package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Pais;
import com.empresa.repository.PaisRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {
    private final PaisRepository repository;
    
    @Override public List<Pais> listarTodos() { return repository.findAll(); }
    @Override public Pais guardar(Pais obj) { return repository.save(obj); }
    @Override public Pais actualizar(Integer id, Pais obj) { obj.setIdPais(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}