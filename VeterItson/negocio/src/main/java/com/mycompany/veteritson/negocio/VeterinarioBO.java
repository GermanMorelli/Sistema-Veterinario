/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.IVeterinarioDao;
import com.mycompany.veteritson.entidades.Veterinario;
import java.util.List;
import java.util.Objects;

public class VeterinarioBO implements IVeterinarioBO {

    private final IVeterinarioDao veterinarioDao;

    public VeterinarioBO(IVeterinarioDao veterinarioDao) {
        this.veterinarioDao = Objects.requireNonNull(
                veterinarioDao, "La DAO de veterinarios es requerida.");
    }

    @Override
    public Veterinario registrar(Veterinario veterinario) {
        validarDatos(veterinario);
        return veterinarioDao.guardar(veterinario);
    }

    @Override
    public Veterinario actualizar(Veterinario veterinario) {
        if (veterinario == null || veterinario.getIdVeterinario() <= 0) {
            throw new IllegalArgumentException("El veterinario debe tener un ID valido.");
        }
        validarDatos(veterinario);
        return veterinarioDao.actualizar(veterinario);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        veterinarioDao.eliminar(id);
    }

    @Override
    public Veterinario buscarPorId(int id) {
        validarId(id);
        return veterinarioDao.buscarPorId(id);
    }

    @Override
    public List<Veterinario> listar() {
        return veterinarioDao.listar();
    }

    private void validarDatos(Veterinario veterinario) {
        if (veterinario == null) {
            throw new IllegalArgumentException("El veterinario no puede ser null.");
        }
        if (veterinario.getNombre() == null || veterinario.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del veterinario es obligatorio.");
        }
        if (veterinario.getTelefono() == null
                || !veterinario.getTelefono().matches("\\d{10}")) {
            throw new IllegalArgumentException("El telefono debe contener exactamente 10 digitos.");
        }
        if (veterinario.getCorreo() == null
                || !veterinario.getCorreo().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("El correo electronico no es valido.");
        }
        if (veterinario.getCedula() == null || veterinario.getCedula().isBlank()) {
            throw new IllegalArgumentException("La cedula profesional es obligatoria.");
        }
        if (veterinario.getDiasDisponible() == null
                || veterinario.getDiasDisponible().isEmpty()) {
            throw new IllegalArgumentException("Debe registrar al menos un día disponible.");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
