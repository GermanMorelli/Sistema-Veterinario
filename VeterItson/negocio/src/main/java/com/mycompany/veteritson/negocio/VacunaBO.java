/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.IVacunaDao;
import com.mycompany.veteritson.entidades.Vacuna;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mario
 */
public class VacunaBO implements IVacunaBO {

    private final IVacunaDao vacunaDao;

    public VacunaBO(IVacunaDao vacunaDao) {
        this.vacunaDao = Objects.requireNonNull(
                vacunaDao, "La DAO de vacunas es requerida.");
    }

    @Override
    public Vacuna registrar(Vacuna vacuna) {
        validarDatos(vacuna);
        return vacunaDao.guardar(vacuna);
    }

    @Override
    public Vacuna actualizar(Vacuna vacuna) {
        if (vacuna == null || vacuna.getIdVacuna() <= 0) {
            throw new IllegalArgumentException("La vacuna debe tener un ID válido.");
        }
        validarDatos(vacuna);
        return vacunaDao.actualizar(vacuna);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        vacunaDao.eliminar(id);
    }

    @Override
    public Vacuna buscarPorId(int id) {
        validarId(id);
        return vacunaDao.bucarPorId(id);
    }

    @Override
    public List<Vacuna> listar() {
        return vacunaDao.listar();
    }

    @Override
    public List<Vacuna> listarPorCartilla(int idCartilla) {
        validarId(idCartilla);
        return vacunaDao.listarPorCartilla(idCartilla);
    }

    private void validarDatos(Vacuna vacuna) {
        if (vacuna == null) {
            throw new IllegalArgumentException("La vacuna no puede ser null.");
        }
        if (vacuna.getIdCartilla() <= 0) {
            throw new IllegalArgumentException("La vacuna debe tener un ID de cartilla valido.");
        }
        if (vacuna.getNombre() == null || vacuna.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la vacuna es obligatorio.");
        }
        if (vacuna.getFechaAplicacion() == null) {
            throw new IllegalArgumentException("La fecha de aplicacion es obligatoria.");
        }
        if (vacuna.getLote() == null || vacuna.getLote().isBlank()) {
            throw new IllegalArgumentException("El lote de la vacuna es obligatorio.");
        }
        if (vacuna.getEstado() == null || vacuna.getEstado().isBlank()) {
            throw new IllegalArgumentException("El estado de la vacuna es obligatorio.");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
