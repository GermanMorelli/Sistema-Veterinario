package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Veterinario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class VeterinarioDao implements IVeterinarioDao {

    private final EntityManager entityManager;

    public VeterinarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(veterinario);
        transaccion.commit();
        return veterinario;
    }

    @Override
    public Veterinario actualizar(Veterinario veterinario) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Veterinario veterinarioActualizado = entityManager.merge(veterinario);
        transaccion.commit();
        return veterinarioActualizado;
    }

    @Override
    public void eliminar(int id) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Veterinario veterinario = entityManager.find(Veterinario.class, id);
        if (veterinario != null) {
            entityManager.remove(veterinario);
        }
        transaccion.commit();
    }

    @Override
    public Veterinario buscarPorId(int id) {
        return entityManager.find(Veterinario.class, id);
    }

    @Override
    public List<Veterinario> listar() {
        return entityManager.createQuery(
                "SELECT v FROM Veterinario v", Veterinario.class)
                .getResultList();
    }
}