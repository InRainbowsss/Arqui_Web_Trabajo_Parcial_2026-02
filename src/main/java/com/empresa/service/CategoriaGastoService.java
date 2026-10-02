package com.empresa.service;

import java.util.List;
import com.empresa.entity.CategoriaGasto;

public interface CategoriaGastoService {
    public abstract List<CategoriaGasto> listarTodos();
    public abstract CategoriaGasto guardar(CategoriaGasto obj);
    public abstract CategoriaGasto actualizar(Integer id, CategoriaGasto obj);
    public abstract void eliminar(Integer id);
}