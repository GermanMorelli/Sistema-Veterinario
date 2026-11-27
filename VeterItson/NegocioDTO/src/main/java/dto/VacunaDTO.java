/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author DANIEL
 */
public class VacunaDTO {
    private int idVacuna;
    private int idCartilla;
    private String nombre;
    private LocalDate fechaAplicacion;
    private String lote;
    private String estado;

    public VacunaDTO() {
    }

    public VacunaDTO(int idVacuna, int idCartilla, String nombre, LocalDate fechaAplicacion, String lote, String estado) {
        this.idVacuna = idVacuna;
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
}
