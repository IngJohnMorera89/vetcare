package com.devsenio.jmorera.vetcare.DTO;

import com.devsenio.jmorera.vetcare.model.Rol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRequest(

                @NotBlank(message = "El nombre de usuario es obligatorio") String username,

                @NotBlank(message = "La contraseña es obligatoria") String password,

                @NotNull(message = "El rol es obligatorio") Rol rol) {

}
