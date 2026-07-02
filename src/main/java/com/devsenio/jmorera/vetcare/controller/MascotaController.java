package com.devsenio.jmorera.vetcare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenio.jmorera.vetcare.model.Mascota;
import com.devsenio.jmorera.vetcare.service.MascotaService;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarTodos() {
        return ResponseEntity.ok(mascotaService.listarTodos());
    }

}
