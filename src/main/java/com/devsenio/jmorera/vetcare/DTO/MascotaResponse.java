package com.devsenio.jmorera.vetcare.DTO;

public record MascotaResponse(
        Long id,
        String nombre,
        String especie,
        String raza,
        Integer edad,
        Long duenoId,
        String duenoNombre) {

}
