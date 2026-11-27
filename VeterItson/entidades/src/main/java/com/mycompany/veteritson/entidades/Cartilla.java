package com.mycompany.veteritson.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cartilla")
public class Cartilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCartilla")
    private int idCartilla;

    @Column(name = "idMascota")
    private int idMascota;

    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion;

    public Cartilla() {
    }

    public Cartilla(int idMascota, LocalDate fechaCreacion) {
        this.idMascota = idMascota;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCartilla() {
        return idCartilla;
    }

    public void setIdCartilla(int idCartilla) {
        this.idCartilla = idCartilla;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
