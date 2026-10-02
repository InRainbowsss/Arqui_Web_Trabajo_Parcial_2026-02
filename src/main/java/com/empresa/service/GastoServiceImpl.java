package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.Gasto;
import com.empresa.repository.GastoRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class GastoServiceImpl implements GastoService {
    private final GastoRepository repository;
    
    @Override public List<Gasto> listarTodos() { return repository.findAll(); }
    @Override public Gasto guardar(Gasto obj) { return repository.save(obj); }
    @Override public Gasto actualizar(Integer id, Gasto obj) { obj.setIdGasto(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}