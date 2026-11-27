package com.mycompany.veteritson.entidades;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeterinario")
    private int idVeterinario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "cedula")
    private String cedula;

    @ElementCollection
    @CollectionTable(name = "veterinario_dias_disponibles",
            joinColumns = @JoinColumn(name = "idVeterinario"))
    @Column(name = "dia")
    private List<String> diasDisponible = new ArrayList<>();

    public Veterinario() {
    }

    public Veterinario(String nombre, String telefono, String correo, String cedula,
            List<String> diasDisponible) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.diasDisponible = diasDisponible;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<String> getDiasDisponible() {
        return diasDisponible;
    }

    public void setDiasDisponible(List<String> diasDisponible) {
        this.diasDisponible = diasDisponible;
    }
}
