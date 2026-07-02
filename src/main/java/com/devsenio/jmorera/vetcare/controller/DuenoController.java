package com.devsenio.jmorera.vetcare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenio.jmorera.vetcare.model.Dueno;
import com.devsenio.jmorera.vetcare.service.DuenoService;

@RestController
@RequestMapping("/api/duenos")
public class DuenoController {

    private final DuenoService duenoService;

    public DuenoController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    @GetMapping
    public ResponseEntity<List<Dueno>> listarTodos() {
        return ResponseEntity.ok(duenoService.ListarTodos());
    }

}
