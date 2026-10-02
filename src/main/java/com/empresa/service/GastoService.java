package com.empresa.service;

import java.util.List;
import com.empresa.entity.Gasto;

public interface GastoService {
    public abstract List<Gasto> listarTodos();
    public abstract Gasto guardar(Gasto obj);
    public abstract Gasto actualizar(Integer id, Gasto obj);
    public abstract void eliminar(Integer id);
}