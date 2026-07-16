package com.devsenio.jmorera.vetcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenio.jmorera.vetcare.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
