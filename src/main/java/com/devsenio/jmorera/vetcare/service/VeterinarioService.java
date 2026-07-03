package com.devsenio.jmorera.vetcare.service;

import java.util.List;

import com.devsenio.jmorera.vetcare.DTO.VeterinarioRequest;
import com.devsenio.jmorera.vetcare.DTO.VeterinarioResponse;

public interface VeterinarioService {

    List<VeterinarioResponse> listarTodos();

    VeterinarioResponse buscarPorId(Long id);

    VeterinarioResponse crear(VeterinarioRequest request);

    VeterinarioResponse actualizar(Long id, VeterinarioRequest request);

    void eliminar(Long id);

}
