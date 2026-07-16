package com.devsenio.jmorera.vetcare.DTO;

import com.devsenio.jmorera.vetcare.model.Rol;

import jakarta.validation.constraints.NotBlank;

public record RegistroRequest(

        @NotBlank(message = "El nombre de usuario es obligatorio") String username,

        @NotBlank(message = "La contraseña es obligatoria") String password,

        @NotBlank(message = "El rol es obligatorio") Rol rol) {

}
