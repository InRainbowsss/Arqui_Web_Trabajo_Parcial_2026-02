package com.empresa.service;

import java.util.List;
import com.empresa.entity.Catalogo;

public interface CatalogoService {
    public abstract List<Catalogo> listarTodos();
    public abstract Catalogo guardar(Catalogo obj);
    public abstract Catalogo actualizar(Integer id, Catalogo obj);
    public abstract void eliminar(Integer id);
}