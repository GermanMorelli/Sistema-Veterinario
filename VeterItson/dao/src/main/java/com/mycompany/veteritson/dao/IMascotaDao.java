package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Mascota;
import java.util.List;

public interface IMascotaDao {
    Mascota guardar(Mascota mascota);
    Mascota actualizar(Mascota mascota);
    void eliminar(int id);
    Mascota buscarPorId(int id);
    List<Mascota> listar();
}
