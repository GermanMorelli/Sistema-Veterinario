/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.ICitaDao;
import com.mycompany.veteritson.entidades.Cita;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CitaBO implements ICitaBO {

    private final ICitaDao citaDao;

    public CitaBO(ICitaDao citaDao) {
        this.citaDao = Objects.requireNonNull(
                citaDao, "La DAO de citas es requerida.");
    }

    @Override
    public Cita registrar(Cita cita) {
        validarDatos(cita);
        return citaDao.guardar(cita);
    }

    @Override
    public Cita actualizar(Cita cita) {
        if (cita == null || cita.getIdCita() <= 0) {
            throw new IllegalArgumentException("La cita debe tener un ID válido.");
        }
        validarDatos(cita);
        return citaDao.actualizar(cita);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        citaDao.eliminar(id);
    }

    @Override
    public Cita buscarPorId(int id) {
        validarId(id);
        return citaDao.buscarPorId(id);
    }

    @Override
    public List<Cita> listar() {
        return citaDao.listar();
    }

    @Override
    public List<Cita> listarPorVeterinario(int idVet, LocalDate fecha) {
        validarId(idVet);

        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es obligatoria.");
        }

        return citaDao.listarPorVeterinario(idVet, fecha);
    }

    private void validarDatos(Cita cita) {
        if (cita == null) {
            throw new IllegalArgumentException("La cita no puede ser null.");
        }
        if (cita.getIdCliente() <= 0) {
            throw new IllegalArgumentException("La cita debe tener un ID de cliente válido.");
        }
        if (cita.getIdMascota() <= 0) {
            throw new IllegalArgumentException("La cita debe tener un ID de mascota válido.");
        }
        if (cita.getIdVeterinario() <= 0) {
            throw new IllegalArgumentException("La cita debe tener un ID de veterinario válido.");
        }
        if (cita.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la cita es obligatoria.");
        }
        if (cita.getHora() == null) {
            throw new IllegalArgumentException("La hora de la cita es obligatoria.");
        }
        if (cita.getMotivo() == null || cita.getMotivo().isBlank()) {
            throw new IllegalArgumentException("El motivo de la cita es obligatorio.");
        }
        if (cita.getEstado() == null || cita.getEstado().isBlank()) {
            throw new IllegalArgumentException("El estado de la cita es obligatorio.");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
