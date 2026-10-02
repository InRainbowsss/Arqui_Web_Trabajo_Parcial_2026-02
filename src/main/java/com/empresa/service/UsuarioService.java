package com.empresa.service;

import java.util.List;
import com.empresa.entity.Usuario;

public interface UsuarioService {
    public abstract List<Usuario> listarTodos();
    public abstract Usuario guardar(Usuario obj);
    public abstract Usuario actualizar(Integer id, Usuario obj);
    public abstract void eliminar(Integer id);
}