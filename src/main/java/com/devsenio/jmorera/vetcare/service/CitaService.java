package com.devsenio.jmorera.vetcare.service;

import java.util.List;

import com.devsenio.jmorera.vetcare.DTO.CitaRequest;
import com.devsenio.jmorera.vetcare.DTO.CitaResponse;

public interface CitaService {
    List<CitaResponse> listarTodos();

    CitaResponse buscarPorId(Long id);

    CitaResponse crear(CitaRequest request);

    CitaResponse actualizar(Long id, CitaRequest request);

    void eliminar(Long id);

}
