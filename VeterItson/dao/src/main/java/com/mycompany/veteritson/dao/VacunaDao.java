package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Vacuna;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class VacunaDao implements IVacunaDao {

    private final EntityManager entityManager;

    public VacunaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Vacuna guardar(Vacuna vacuna){
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        entityManager.persist(vacuna);
        transaccion.commit();
        return vacuna;
    }
    
    @Override
    public Vacuna actualizar(Vacuna vacuna){
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Vacuna vacunaActualizada = entityManager.merge(vacuna);
        transaccion.commit();
        return vacunaActualizada;
    }

    @Override
    public void eliminar(int id){
        EntityTransaction transaccion = entityManager.getTransaction();
        transaccion.begin();
        Vacuna vacuna = entityManager.find(Vacuna.class, id);
        if (vacuna != null){
            entityManager.remove(vacuna);
        }
        transaccion.commit();
    }    

    @Override
    public Vacuna bucarPorId(int id) {
        return entityManager.find(Vacuna.class, id);
    }

    @Override
    public List<Vacuna> listar() {
        return entityManager.createQuery(
                "SELECT v FROM Vacuna v", Vacuna.class)
                .getResultList();
    }

    @Override
    public List<Vacuna> listarPorCartilla(int idCartilla) {
        return entityManager.createQuery("SELECT v FROM Vacuna v WHERE v.idCartilla = :idCartilla",
        Vacuna.class).setParameter("idCartilla", idCartilla).getResultList();
    }
}
