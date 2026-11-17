package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cita;
import java.util.List;

public interface ICitaDao {
    Cita guardar(Cita cita);
    Cita actualizar(Cita cita);
    void eliminar(int id);
    Cita buscarPorId(int id);
    List<Cita> listar();
}
