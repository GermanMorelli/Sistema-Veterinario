package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Veterinario;
import java.util.List;

public interface IVeterinarioBO {

    Veterinario registrar(Veterinario veterinario);

    Veterinario actualizar(Veterinario veterinario);

    void eliminar(int id);

    Veterinario buscarPorId(int id);

    List<Veterinario> listar();
}
