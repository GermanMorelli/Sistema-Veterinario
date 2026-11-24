package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Vacuna;
import java.util.List;

public interface IVacunaBO {

    Vacuna registrar(Vacuna vacuna);

    Vacuna actualizar(Vacuna vacuna);

    void eliminar(int id);

    Vacuna buscarPorId(int id);

    List<Vacuna> listar();

    List<Vacuna> listarPorCartilla(int idCartilla);
}
