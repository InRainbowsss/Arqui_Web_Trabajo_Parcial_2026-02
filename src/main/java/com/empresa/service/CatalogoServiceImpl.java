package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Catalogo;
import com.empresa.repository.CatalogoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {
    private final CatalogoRepository repository;
    
    @Override public List<Catalogo> listarTodos() { return repository.findAll(); }
    @Override public Catalogo guardar(Catalogo obj) { return repository.save(obj); }
    @Override public Catalogo actualizar(Integer id, Catalogo obj) { obj.setIdCatalogo(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}