package com.empresa.service;

import java.util.List;
import com.empresa.entity.UsuarioHasRol;

public interface UsuarioHasRolService {
    public abstract List<UsuarioHasRol> listarTodos();
    public abstract UsuarioHasRol guardar(UsuarioHasRol obj);
    public abstract UsuarioHasRol actualizar(Integer id, UsuarioHasRol obj);
    public abstract void eliminar(Integer id);
}