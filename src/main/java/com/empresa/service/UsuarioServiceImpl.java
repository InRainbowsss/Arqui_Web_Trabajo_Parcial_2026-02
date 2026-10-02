package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    
    @Override public List<Usuario> listarTodos() { return repository.findAll(); }
    @Override public Usuario guardar(Usuario obj) { return repository.save(obj); }
    @Override public Usuario actualizar(Integer id, Usuario obj) { obj.setIdUsuario(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}