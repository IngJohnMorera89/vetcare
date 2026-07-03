package com.devsenio.jmorera.vetcare.DTO;

public record DuenoResponse(
        Long id,
        String nombre,
        String apellido,
        String documento,
        String telefono,
        String email) {

}
