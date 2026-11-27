package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.IMascotaDao;
import com.mycompany.veteritson.entidades.Mascota;
import java.util.List;
import java.util.Objects;

public class MascotaBO implements IMascotaBO {

    private final IMascotaDao mascotaDao;

    public MascotaBO(IMascotaDao mascotaDao) {
        this.mascotaDao = Objects.requireNonNull(mascotaDao, "La DAO de mascotas es requerida.");
    }

    @Override
    public Mascota registrar(Mascota mascota) {
        validarDatos(mascota);
        return mascotaDao.guardar(mascota);
    }

    @Override
    public Mascota actualizar(Mascota mascota) {
        if (mascota == null || mascota.getIdMascota() <= 0) {
            throw new IllegalArgumentException("La mascota debe tener un ID válido.");
        }
        validarDatos(mascota);
        return mascotaDao.actualizar(mascota);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        mascotaDao.eliminar(id);
    }

    @Override
    public Mascota buscarPorId(int id) {
        validarId(id);
        return mascotaDao.buscarPorId(id);
    }

    @Override
    public List<Mascota> listar() {
        return mascotaDao.listar();
    }

    private void validarDatos(Mascota mascota) {
        if (mascota == null) {
            throw new IllegalArgumentException("La mascota no puede ser null.");
        }
        if (mascota.getIdCliente() <= 0) {
            throw new IllegalArgumentException("La mascota debe tener un ID de cliente válido.");
        }
        if (mascota.getNombre() == null || mascota.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre de la mascota es obligatorio.");
        }
        if (mascota.getEspecie() == null || mascota.getEspecie().isBlank()) {
            throw new IllegalArgumentException("La especie de la mascota es obligatoria.");
        }
        if (mascota.getRaza() == null || mascota.getRaza().isBlank()) {
            throw new IllegalArgumentException("La raza de la mascota es obligatoria.");
        }
        if (mascota.getSexo() == null || mascota.getSexo().isBlank()) {
            throw new IllegalArgumentException("El sexo de la mascota es obligatorio.");
        }
        if (!Double.isFinite(mascota.getPeso()) || mascota.getPeso() <= 0) {
            throw new IllegalArgumentException("El peso debe ser un número mayor que cero.");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
