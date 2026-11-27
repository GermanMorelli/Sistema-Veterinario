package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.entidades.Cliente;
import java.util.List;

public interface IClienteBO {
    Cliente registrar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    void eliminar(int id);
    Cliente buscarPorId(int id);
    List<Cliente> listar();
}
