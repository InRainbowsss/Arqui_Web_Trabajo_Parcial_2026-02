package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Rol;
import com.empresa.repository.RolRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository repository;
    
    @Override public List<Rol> listarTodos() { return repository.findAll(); }
    @Override public Rol guardar(Rol obj) { return repository.save(obj); }
    @Override public Rol actualizar(Integer id, Rol obj) { obj.setIdRol(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}