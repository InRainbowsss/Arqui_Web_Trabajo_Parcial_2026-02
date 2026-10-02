package com.empresa.service;

import java.util.List;
import com.empresa.entity.Rol;

public interface RolService {
    public abstract List<Rol> listarTodos();
    public abstract Rol guardar(Rol obj);
    public abstract Rol actualizar(Integer id, Rol obj);
    public abstract void eliminar(Integer id);
}