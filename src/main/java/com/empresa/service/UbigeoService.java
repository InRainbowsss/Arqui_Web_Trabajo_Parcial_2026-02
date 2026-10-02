package com.empresa.service;

import java.util.List;
import com.empresa.entity.Ubigeo;

public interface UbigeoService {
    public abstract List<Ubigeo> listarTodos();
    public abstract Ubigeo guardar(Ubigeo obj);
    public abstract Ubigeo actualizar(Integer id, Ubigeo obj);
    public abstract void eliminar(Integer id);
}