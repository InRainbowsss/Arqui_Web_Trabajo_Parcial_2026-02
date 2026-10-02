package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.DataCatalogo;
import com.empresa.repository.DataCatalogoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class DataCatalogoServiceImpl implements DataCatalogoService {
    private final DataCatalogoRepository repository;
    
    @Override public List<DataCatalogo> listarTodos() { return repository.findAll(); }
    @Override public DataCatalogo guardar(DataCatalogo obj) { return repository.save(obj); }
    @Override public DataCatalogo actualizar(Integer id, DataCatalogo obj) { obj.setIdDataCatalogo(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}