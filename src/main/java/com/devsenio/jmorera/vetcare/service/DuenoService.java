package com.devsenio.jmorera.vetcare.service;

import java.util.List;

import com.devsenio.jmorera.vetcare.DTO.DuenoRequest;
import com.devsenio.jmorera.vetcare.DTO.DuenoResponse;

public interface DuenoService {
    List<DuenoResponse> listarTodos();

    DuenoResponse buscarPorId(Long id);

    DuenoResponse crear(DuenoRequest request);

    DuenoResponse actualizar(Long id, DuenoRequest request);

    void eliminar(Long id);
}
