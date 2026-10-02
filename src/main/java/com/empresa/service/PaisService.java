package com.empresa.service;

import java.util.List;
import com.empresa.entity.Pais;

public interface PaisService {
    public abstract List<Pais> listarTodos();
    public abstract Pais guardar(Pais obj);
    public abstract Pais actualizar(Integer id, Pais obj);
    public abstract void eliminar(Integer id);
}