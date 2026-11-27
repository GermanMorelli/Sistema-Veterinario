package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ClienteDao implements IClienteDao {

    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(cliente);
        transaccion.commit();
        return cliente;
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cliente clienteActualizado = entityManager.merge(cliente);
        transaccion.commit();
        return clienteActualizado;
    }

    @Override
    public void eliminar(int id) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
        transaccion.commit();
    }

    @Override
    public Cliente buscarPorId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> listar() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
