package com.empresa.service;

import java.util.List;
import com.empresa.entity.DataCatalogo;

public interface DataCatalogoService {
    public abstract List<DataCatalogo> listarTodos();
    public abstract DataCatalogo guardar(DataCatalogo obj);
    public abstract DataCatalogo actualizar(Integer id, DataCatalogo obj);
    public abstract void eliminar(Integer id);
}