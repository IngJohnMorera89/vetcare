package com.devsenio.jmorera.vetcare.service;

import com.devsenio.jmorera.vetcare.DTO.AuthResponse;
import com.devsenio.jmorera.vetcare.DTO.LoginRequest;
import com.devsenio.jmorera.vetcare.DTO.RegistroRequest;

public interface AuthService {
    AuthResponse registrar(RegistroRequest request);

    AuthResponse login(LoginRequest request);

}
