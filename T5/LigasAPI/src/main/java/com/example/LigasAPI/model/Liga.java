package com.example.LigasAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

// anotaciones de JPA para el mapeo con la base de datos
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "ligas")
public class Liga implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column (name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column (name = "fecha_fin")
    private LocalDate fechaFin;

    public Liga(String nombre) {
        this.nombre = nombre;
    }

    public Liga() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Liga(LocalDate fechaFin, LocalDate fechaInicio, String nombre, int id) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.id = id;
    }
}
