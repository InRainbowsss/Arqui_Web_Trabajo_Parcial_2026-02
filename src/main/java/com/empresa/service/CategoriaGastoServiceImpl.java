package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.CategoriaGasto;
import com.empresa.repository.CategoriaGastoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class CategoriaGastoServiceImpl implements CategoriaGastoService {

    private final CategoriaGastoRepository repository;
    
    @Override
    public List<CategoriaGasto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public CategoriaGasto guardar(CategoriaGasto obj) {
        return repository.save(obj);
    }

    @Override
    public CategoriaGasto actualizar(Integer id, CategoriaGasto obj) {
        obj.setIdCategoria(id);
        return repository.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}