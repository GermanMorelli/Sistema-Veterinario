package com.mycompany.veteritson.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "vacuna")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVacuna")
    private int idVacuna;

    @Column(name = "idCartilla")
    private int idCartilla;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fechaAplicacion")
    private LocalDate fechaAplicacion;

    @Column(name = "lote")
    private String lote;

    @Column(name = "estado")
    private String estado;

    public Vacuna() {
    }

    public Vacuna(int idCartilla, String nombre, LocalDate fechaAplicacion,
            String lote, String estado) {
        this.idCartilla = idCartilla;
        this.nombre = nombre;
        this.fechaAplicacion = fechaAplicacion;
        this.lote = lote;
        this.estado = estado;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getIdCartilla() {
        return idCartilla;
    }

    public void setIdCartilla(int idCartilla) {
        this.idCartilla = idCartilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
