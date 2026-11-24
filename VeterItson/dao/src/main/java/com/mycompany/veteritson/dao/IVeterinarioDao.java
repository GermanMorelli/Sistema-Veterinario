package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Veterinario;
import java.util.List;

public interface IVeterinarioDao {
    Veterinario guardar(Veterinario veterinario);
    Veterinario actualizar(Veterinario veterinario);
    void eliminar(int id);
    Veterinario buscarPorId(int id);
    List<Veterinario> listar();
}