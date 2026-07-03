package com.devsenio.jmorera.vetcare.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Audited.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;

    @Column(unique = true)
    private String tarjetaProfesional;

    // Un veterinario atiende muchas citas
    @OneToMany(mappedBy = "veterinario")
    @JsonIgnore
    private List<Cita> citas = new ArrayList<>();

    public Veterinario() {
    }

    public Veterinario(Long id, String nombre, String especialidad, String tarjetaProfesional, List<Cita> citas) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.tarjetaProfesional = tarjetaProfesional;
        this.citas = citas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

}
