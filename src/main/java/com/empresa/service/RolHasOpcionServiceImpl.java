package com.empresa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.empresa.entity.RolHasOpcion;
import com.empresa.repository.RolHasOpcionRepository;
import lombok.RequiredArgsConstructor;

@Service    
@RequiredArgsConstructor
public class RolHasOpcionServiceImpl implements RolHasOpcionService {
    private final RolHasOpcionRepository repository;
    
    @Override public List<RolHasOpcion> listarTodos() { return repository.findAll(); }
    @Override public RolHasOpcion guardar(RolHasOpcion obj) { return repository.save(obj); }
    @Override public RolHasOpcion actualizar(Integer id, RolHasOpcion obj) { obj.setIdRolOpcion(id); return repository.save(obj); }
    @Override public void eliminar(Integer id) { repository.deleteById(id); }
}