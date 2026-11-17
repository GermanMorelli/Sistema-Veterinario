package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class CitaDao implements ICitaDao {

    private final EntityManager entityManager;

    public CitaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cita guardar(Cita cita) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(cita);
        transaccion.commit();
        return cita;
    }

    @Override
    public Cita actualizar(Cita cita) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cita citaActualizada = entityManager.merge(cita);
        transaccion.commit();
        return citaActualizada;
    }

    @Override
    public void eliminar(int id) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cita cita = entityManager.find(Cita.class, id);
        if (cita != null) {
            entityManager.remove(cita);
        }
        transaccion.commit();
    }

    @Override
    public Cita buscarPorId(int id) {
        return entityManager.find(Cita.class, id);
    }

    @Override
    public List<Cita> listar() {
        return entityManager.createQuery("SELECT c FROM Cita c", Cita.class)
                .getResultList();
    }
}
