package com.empresa.service;

import java.util.List;
import com.empresa.entity.RecursoEducativo;

public interface RecursoEducativoService {
    public abstract List<RecursoEducativo> listarTodos();
    public abstract RecursoEducativo guardar(RecursoEducativo obj);
    public abstract RecursoEducativo actualizar(Integer id, RecursoEducativo obj);
    public abstract void eliminar(Integer id);
}