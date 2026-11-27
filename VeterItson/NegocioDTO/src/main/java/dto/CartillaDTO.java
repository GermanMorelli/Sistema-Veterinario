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
public class CartillaDTO {
    private int idCartilla;
    private int idMascota;
    private LocalDate fechaCreacion;

    public CartillaDTO() {
    }

    public CartillaDTO(int idCartilla, int idMascota, LocalDate fechaCreacion) {
        this.idCartilla = idCartilla;
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