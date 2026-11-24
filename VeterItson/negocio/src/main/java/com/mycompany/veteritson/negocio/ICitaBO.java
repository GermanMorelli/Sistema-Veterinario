package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Cita;
import java.time.LocalDate;
import java.util.List;

public interface ICitaBO {

    Cita registrar(Cita cita);

    Cita actualizar(Cita cita);

    void eliminar(int id);

    Cita buscarPorId(int id);

    List<Cita> listar();

    List<Cita> listarPorVeterinario(int idVet, LocalDate fecha);
}
