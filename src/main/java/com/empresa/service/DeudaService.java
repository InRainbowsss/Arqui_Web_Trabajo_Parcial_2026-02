package com.empresa.service;

import java.util.List;
import com.empresa.entity.Deuda;

public interface DeudaService {
    public abstract List<Deuda> listarTodos();
    public abstract Deuda guardar(Deuda obj);
    public abstract Deuda actualizar(Integer id, Deuda obj);
    public abstract void eliminar(Integer id);
}