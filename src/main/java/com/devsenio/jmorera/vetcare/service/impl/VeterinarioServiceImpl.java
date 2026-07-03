package com.devsenio.jmorera.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenio.jmorera.vetcare.DTO.VeterinarioRequest;
import com.devsenio.jmorera.vetcare.DTO.VeterinarioResponse;
import com.devsenio.jmorera.vetcare.exception.RecursoNoEncontradoException;
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
    public List<VeterinarioResponse> listarTodos() {
        return veterinarioRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public VeterinarioResponse buscarPorId(Long id) {
        Veterinario vet = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un veterinario con id " + id));
        return toResponse(vet);
    }

    @Override
    public VeterinarioResponse crear(VeterinarioRequest request) {
        Veterinario vet = new Veterinario();
        vet.setNombre(request.nombre());
        vet.setEspecialidad(request.especialidad());
        vet.setTarjetaProfesional(request.tarjetaProfesional());

        Veterinario guardado = veterinarioRepository.save(vet);
        return toResponse(guardado);
    }

    @Override
    public VeterinarioResponse actualizar(Long id, VeterinarioRequest request) {
        Veterinario vet = veterinarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un veterinario con id " + id));

        vet.setNombre(request.nombre());
        vet.setEspecialidad(request.especialidad());
        vet.setTarjetaProfesional(request.tarjetaProfesional());

        Veterinario actualizado = veterinarioRepository.save(vet);
        return toResponse(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!veterinarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe un veterinario con id " + id);
        }
        veterinarioRepository.deleteById(id);
    }

    private VeterinarioResponse toResponse(Veterinario vet) {
        return new VeterinarioResponse(
                vet.getId(), vet.getNombre(), vet.getEspecialidad(), vet.getTarjetaProfesional());
    }
}
