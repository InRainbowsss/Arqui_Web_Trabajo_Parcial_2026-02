package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Ubigeo;
import com.empresa.repository.UbigeoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class UbigeoServiceImpl implements UbigeoService {
    private final UbigeoRepository repository;
    
    @Override public List<Ubigeo> listarTodos() { return repository.findAll(); }
    @Override public Ubigeo guardar(Ubigeo obj) { return repository.save(obj); }
    @Override public Ubigeo actualizar(Integer id, Ubigeo obj) { obj.setIdUbigeo(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}