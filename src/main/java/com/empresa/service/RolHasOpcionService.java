package com.empresa.service;

import java.util.List;
import com.empresa.entity.RolHasOpcion;

public interface RolHasOpcionService {
    public abstract List<RolHasOpcion> listarTodos();
    public abstract RolHasOpcion guardar(RolHasOpcion obj);
    public abstract RolHasOpcion actualizar(Integer id, RolHasOpcion obj);
    public abstract void eliminar(Integer id);
}