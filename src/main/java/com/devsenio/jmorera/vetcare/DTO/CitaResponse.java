package com.devsenio.jmorera.vetcare.DTO;

import java.time.LocalDate;

public record CitaResponse(
        Long id,
        LocalDate fecha,
        String motivo,
        String estado,
        Double costo,
        Long mascotaId,
        String mascotaNombre,
        Long veterinarioId,
        String veterinarioNombre) {

}
