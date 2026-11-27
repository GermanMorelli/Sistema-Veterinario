/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class VeterinarioDTO {
    private int idVeterinario;
    private String nombre;
    private String telefono;
    private String correo;
    private String cedula;
    private List<String> diasDisponible = new ArrayList<>();

    public VeterinarioDTO() {
    }

    public VeterinarioDTO(int idVeterinario, String nombre, String telefono, String correo, String cedula) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
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