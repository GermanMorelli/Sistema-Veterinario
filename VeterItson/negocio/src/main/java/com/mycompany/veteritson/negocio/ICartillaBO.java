package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Cartilla;
import java.util.List;

public interface ICartillaBO {

    Cartilla registrar(Cartilla cartilla);

    Cartilla actualizar(Cartilla cartilla);

    void eliminar(int id);

    Cartilla buscarPorId(int id);

    List<Cartilla> listar();

    Cartilla buscarPorMascota(int idMascota);
}
