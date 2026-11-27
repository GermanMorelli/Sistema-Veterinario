/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cartilla;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Mario
 */
public class CartillaDao implements ICartillaDao{

    private final EntityManager entityManager;

    public CartillaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Cartilla guardar(Cartilla cartilla) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(cartilla);
        transaccion.commit();
        return cartilla;
    }

    @Override
    public Cartilla actualizar(Cartilla cartilla) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cartilla cartillaActualizada = entityManager.merge(cartilla);
        transaccion.commit();
        return cartillaActualizada;
    }

    @Override
    public void eliminar(int id) {
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Cartilla cartilla = entityManager.find(Cartilla.class, id);
        if (cartilla != null ){
            entityManager.remove(cartilla);
        }
        transaccion.commit();
    }

    @Override
    public Cartilla buscarPorId(int id) {
        return  entityManager.find(Cartilla.class, id);
    }

    @Override
    public List<Cartilla> listar() {
        return entityManager.createQuery(
                "SELECT c FROM Cartilla c", Cartilla.class).getResultList();
    }

    @Override
    public Cartilla buscarPorMascota(int idMascota) {
       List<Cartilla> cartillas = entityManager.createQuery(
               "SELECT c FROM Cartilla c WHERE c.idMascota = :idMascota",
               Cartilla.class).setParameter("idMascota", idMascota).getResultList();
       return cartillas.isEmpty() ? null : cartillas.get(0);
    }
}
