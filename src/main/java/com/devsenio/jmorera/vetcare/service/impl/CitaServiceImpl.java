package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.model.Cita;
import com.devsenio.jmorera.vetcare.repository.CitaRepository;
import com.devsenio.jmorera.vetcare.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

}
