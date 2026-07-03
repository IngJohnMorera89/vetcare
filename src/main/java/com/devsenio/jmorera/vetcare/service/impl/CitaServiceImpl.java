package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.DTO.CitaRequest;
import com.devsenio.jmorera.vetcare.DTO.CitaResponse;
import com.devsenio.jmorera.vetcare.exception.RecursoNoEncontradoException;
import com.devsenio.jmorera.vetcare.model.Cita;
import com.devsenio.jmorera.vetcare.model.Mascota;
import com.devsenio.jmorera.vetcare.model.Veterinario;
import com.devsenio.jmorera.vetcare.repository.CitaRepository;
import com.devsenio.jmorera.vetcare.repository.MascotaRepository;
import com.devsenio.jmorera.vetcare.repository.VeterinarioRepository;
import com.devsenio.jmorera.vetcare.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaServiceImpl(CitaRepository citaRepository,
            MascotaRepository mascotaRepository,
            VeterinarioRepository veterinarioRepository) {
        this.citaRepository = citaRepository;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public List<CitaResponse> listarTodos() {
        return citaRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public CitaResponse buscarPorId(Long id) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una cita con id " + id));
        return toResponse(cita);
    }

    @Override
    public CitaResponse crear(CitaRequest request) {
        Mascota mascota = mascotaRepository.findById(request.mascotaId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una mascota con id " + request.mascotaId()));

        Veterinario veterinario = veterinarioRepository.findById(request.veterinarioId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un veterinario con id " + request.veterinarioId()));

        Cita cita = new Cita();
        cita.setFecha(request.fecha());
        cita.setMotivo(request.motivo());
        cita.setEstado(request.estado());
        cita.setCosto(request.costo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        Cita guardada = citaRepository.save(cita);
        return toResponse(guardada);
    }

    @Override
    public CitaResponse actualizar(Long id, CitaRequest request) {
        Cita cita = citaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una cita con id " + id));

        Mascota mascota = mascotaRepository.findById(request.mascotaId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe una mascota con id " + request.mascotaId()));

        Veterinario veterinario = veterinarioRepository.findById(request.veterinarioId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un veterinario con id " + request.veterinarioId()));

        cita.setFecha(request.fecha());
        cita.setMotivo(request.motivo());
        cita.setEstado(request.estado());
        cita.setCosto(request.costo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);

        Cita actualizada = citaRepository.save(cita);
        return toResponse(actualizada);
    }

    @Override
    public void eliminar(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe una cita con id " + id);
        }
        citaRepository.deleteById(id);
    }

    // --- Conversión a DTO de respuesta ---
    private CitaResponse toResponse(Cita cita) {
        Mascota mascota = cita.getMascota();
        Veterinario vet = cita.getVeterinario();
        return new CitaResponse(
                cita.getId(), cita.getFecha(), cita.getMotivo(), cita.getEstado(), cita.getCosto(),
                mascota.getId(), mascota.getNombre(),
                vet.getId(), vet.getNombre());
    }
}
