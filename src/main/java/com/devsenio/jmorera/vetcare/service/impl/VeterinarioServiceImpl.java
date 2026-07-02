package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.model.Veterinario;
import com.devsenio.jmorera.vetcare.repository.VeterinarioRepository;
import com.devsenio.jmorera.vetcare.service.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

}
