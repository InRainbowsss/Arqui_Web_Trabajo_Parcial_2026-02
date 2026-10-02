package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.UsuarioHasRol;
import com.empresa.repository.UsuarioHasRolRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class UsuarioHasRolServiceImpl implements UsuarioHasRolService {
    private final UsuarioHasRolRepository repository;
    
    @Override public List<UsuarioHasRol> listarTodos() { return repository.findAll(); }
    @Override public UsuarioHasRol guardar(UsuarioHasRol obj) { return repository.save(obj); }
    @Override public UsuarioHasRol actualizar(Integer id, UsuarioHasRol obj) { obj.setIdUsuarioRol(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}