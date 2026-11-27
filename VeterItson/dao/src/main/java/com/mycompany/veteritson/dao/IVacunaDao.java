package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Vacuna;
import java.util.List;

public interface IVacunaDao {
    Vacuna guardar(Vacuna vacuna);
    Vacuna actualizar(Vacuna vacuna);
    void eliminar(int id);
    Vacuna bucarPorId(int id);
    List<Vacuna> listar();
    List<Vacuna> listarPorCartilla(int idCartilla);
}
