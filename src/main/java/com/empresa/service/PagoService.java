package com.empresa.service;

import java.util.List;
import com.empresa.entity.Pago;

public interface PagoService {
    public abstract List<Pago> listarTodos();
    public abstract Pago guardar(Pago obj);
    public abstract Pago actualizar(Integer id, Pago obj);
    public abstract void eliminar(Integer id);
}