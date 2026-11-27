/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author DANIEL
 */
public class CitaDTO {
     private int idCita;
    private int idCliente;
    private int idMascota;
    private int idVeterinario;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;

    public CitaDTO() {
    }
    

    public CitaDTO(int idCita, int idCliente, int idMascota, int idVeterinario, LocalDate fecha, LocalTime hora, String motivo, String estado) {
        this.idCita = idCita;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}