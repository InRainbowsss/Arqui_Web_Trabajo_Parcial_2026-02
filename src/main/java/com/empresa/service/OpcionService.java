package com.empresa.service;

import java.util.List;
import com.empresa.entity.Opcion;

public interface OpcionService {
    public abstract List<Opcion> listarTodos();
    public abstract Opcion guardar(Opcion obj);
    public abstract Opcion actualizar(Integer id, Opcion obj);
    public abstract void eliminar(Integer id);
}