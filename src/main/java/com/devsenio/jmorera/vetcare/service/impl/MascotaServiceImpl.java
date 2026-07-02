package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.model.Mascota;
import com.devsenio.jmorera.vetcare.repository.MascotaRepository;
import com.devsenio.jmorera.vetcare.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository masscotaRepository) {
        this.mascotaRepository = masscotaRepository;
    }

    @Override
    public List<Mascota> listarTodos() {
        return mascotaRepository.findAll();

    }

}
