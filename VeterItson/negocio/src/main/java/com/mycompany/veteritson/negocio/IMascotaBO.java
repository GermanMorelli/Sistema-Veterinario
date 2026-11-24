package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Mascota;
import java.util.List;

public interface IMascotaBO {
    Mascota registrar(Mascota mascota);
    Mascota actualizar(Mascota mascota);
    void eliminar(int id);
    Mascota buscarPorId(int id);
    List<Mascota> listar();
}
