package com.empresa.service;

import com.empresa.entity.Pais;
import com.empresa.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository repository;

    @Override
    public List<Pais> listaTodos() {
        return repository.findAll();
    }
}