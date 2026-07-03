package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.DTO.MascotaRequest;
import com.devsenio.jmorera.vetcare.DTO.MascotaResponse;
import com.devsenio.jmorera.vetcare.exception.RecursoNoEncontradoException;
import com.devsenio.jmorera.vetcare.model.Dueno;
import com.devsenio.jmorera.vetcare.model.Mascota;
import com.devsenio.jmorera.vetcare.repository.DuenoRepository;
import com.devsenio.jmorera.vetcare.repository.MascotaRepository;
import com.devsenio.jmorera.vetcare.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final DuenoRepository duenoRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository,
            DuenoRepository duenoRepository) {
        this.mascotaRepository = mascotaRepository;
        this.duenoRepository = duenoRepository;
    }

    @Override
    public List<MascotaResponse> listarTodos() {
        return mascotaRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public MascotaResponse buscarPorId(Long id) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una mascota con id " + id));
        return toResponse(mascota);
    }

    @Override
    public MascotaResponse crear(MascotaRequest request) {
        Dueno dueno = duenoRepository.findById(request.duenoId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un dueño con id " + request.duenoId()));

        Mascota mascota = new Mascota();
        mascota.setNombre(request.nombre());
        mascota.setEspecie(request.especie());
        mascota.setRaza(request.raza());
        mascota.setEdad(request.edad());
        mascota.setDueno(dueno);

        Mascota guardada = mascotaRepository.save(mascota);
        return toResponse(guardada);
    }

    @Override
    public MascotaResponse actualizar(Long id, MascotaRequest request) {
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una mascota con id " + id));

        Dueno dueno = duenoRepository.findById(request.duenoId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un dueño con id " + request.duenoId()));

        mascota.setNombre(request.nombre());
        mascota.setEspecie(request.especie());
        mascota.setRaza(request.raza());
        mascota.setEdad(request.edad());
        mascota.setDueno(dueno);

        Mascota actualizada = mascotaRepository.save(mascota);
        return toResponse(actualizada);
    }

    @Override
    public void eliminar(Long id) {
        if (!mascotaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe una mascota con id " + id);
        }
        mascotaRepository.deleteById(id);
    }

    // --- Conversión a DTO de respuesta ---
    private MascotaResponse toResponse(Mascota mascota) {
        Dueno dueno = mascota.getDueno();
        String nombreCompleto = dueno.getNombre() + " " + dueno.getApellido();
        return new MascotaResponse(
                mascota.getId(), mascota.getNombre(), mascota.getEspecie(),
                mascota.getRaza(), mascota.getEdad(),
                dueno.getId(), nombreCompleto);
    }
}
