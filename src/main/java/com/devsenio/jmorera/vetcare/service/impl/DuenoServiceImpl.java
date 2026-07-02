package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.model.Dueno;
import com.devsenio.jmorera.vetcare.repository.DuenoRepository;
import com.devsenio.jmorera.vetcare.service.DuenoService;

@Service
public class DuenoServiceImpl implements DuenoService {

    private final DuenoRepository duenoRepository;

    public DuenoServiceImpl(DuenoRepository duenoRepository) {
        this.duenoRepository = duenoRepository;
    }

    @Override
    public List<Dueno> ListarTodos() {
        return duenoRepository.findAll();
    }

}
