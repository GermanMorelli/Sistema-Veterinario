package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.ICartillaDao;
import com.mycompany.veteritson.entidades.Cartilla;
import java.util.List;
import java.util.Objects;

public class CartillaBO implements ICartillaBO {
    private final ICartillaDao cartillaDao;

    public CartillaBO(ICartillaDao cartillaDao) {
        this.cartillaDao = Objects.requireNonNull(
                cartillaDao, "La DAO de cartillas es requerida.");
    }

    @Override
    public Cartilla registrar(Cartilla cartilla) {
        validarDatos(cartilla);
        return cartillaDao.guardar(cartilla);
    }

    @Override
    public Cartilla actualizar(Cartilla cartilla) {
        if (cartilla == null || cartilla.getIdCartilla() <= 0) {
            throw new IllegalArgumentException("La cartilla debe tener un ID valido.");
        }
        validarDatos(cartilla);
        return cartillaDao.actualizar(cartilla);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        cartillaDao.eliminar(id);
    }

    @Override
    public Cartilla buscarPorId(int id) {
        validarId(id);
        return cartillaDao.buscarPorId(id);
    }

    @Override
    public List<Cartilla> listar() {
        return cartillaDao.listar();
    }

    @Override
    public Cartilla buscarPorMascota(int idMascota) {
        validarId(idMascota);
        return cartillaDao.buscarPorMascota(idMascota);
    }

    private void validarDatos(Cartilla cartilla) {
        if (cartilla == null) {
            throw new IllegalArgumentException("La cartilla no puede ser null.");
        }
        if (cartilla.getIdMascota() <= 0) {
            throw new IllegalArgumentException("La cartilla debe tener un ID de mascota valido.");
        }
        if (cartilla.getFechaCreacion() == null) {
            throw new IllegalArgumentException("La fecha de creacion es obligatoria.");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
