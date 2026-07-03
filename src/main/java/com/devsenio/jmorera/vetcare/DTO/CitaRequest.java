package com.devsenio.jmorera.vetcare.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CitaRequest(
        @NotNull(message = "La fecha es obligatoria") LocalDate fecha,

        @NotBlank(message = "El motivo es obligatorio") String motivo,

        String estado,
        Double costo,

        @NotNull(message = "El id de la mascota es obligatorio") Long mascotaId,

        @NotNull(message = "El id del veterinario es obligatorio") Long veterinarioId) {

}
