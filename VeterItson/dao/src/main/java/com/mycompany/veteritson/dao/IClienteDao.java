package com.mycompany.veteritson.dao;

import com.mycompany.veteritson.entidades.Cliente;
import java.util.List;

public interface IClienteDao {
    Cliente guardar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    void eliminar(int id);
    Cliente buscarPorId(int id);
    List<Cliente> listar();
}
