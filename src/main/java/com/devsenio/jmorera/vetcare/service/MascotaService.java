package com.devsenio.jmorera.vetcare.service;

import java.util.List;

import com.devsenio.jmorera.vetcare.DTO.MascotaRequest;
import com.devsenio.jmorera.vetcare.DTO.MascotaResponse;

public interface MascotaService {
    List<MascotaResponse> listarTodos();

    MascotaResponse buscarPorId(Long id);

    MascotaResponse crear(MascotaRequest request);

    MascotaResponse actualizar(Long id, MascotaRequest request);

    void eliminar(Long id);

}
