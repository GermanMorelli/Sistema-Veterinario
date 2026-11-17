package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Mascota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class MascotaDao implements IMascotaDao {

    private final EntityManager entityManager;

    public MascotaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(mascota);
        transaccion.commit();
        return mascota;
    }

    @Override
    public Mascota actualizar(Mascota mascota) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Mascota mascotaActualizada = entityManager.merge(mascota);
        transaccion.commit();
        return mascotaActualizada;
    }

    @Override
    public void eliminar(int id) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Mascota mascota = entityManager.find(Mascota.class, id);
        if (mascota != null) {
            entityManager.remove(mascota);
        }
        transaccion.commit();
    }

    @Override
    public Mascota buscarPorId(int id) {
        return entityManager.find(Mascota.class, id);
    }

    @Override
    public List<Mascota> listar() {
        return entityManager.createQuery("SELECT m FROM Mascota m", Mascota.class)
                .getResultList();
    }
}
