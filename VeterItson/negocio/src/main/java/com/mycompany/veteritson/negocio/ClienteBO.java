package com.mycompany.veteritson.negocio;

import com.mycompany.veteritson.dao.IClienteDao;
import com.mycompany.veteritson.entidades.Cliente;
import java.util.List;
import java.util.Objects;

public class ClienteBO implements IClienteBO {

    private final IClienteDao clienteDao;

    public ClienteBO(IClienteDao clienteDao) {
        this.clienteDao = Objects.requireNonNull(clienteDao, "La DAO de clientes es requerida.");
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        validarDatos(cliente);
        return clienteDao.guardar(cliente);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        if (cliente == null || cliente.getIdCliente() <= 0) {
            throw new IllegalArgumentException("El cliente debe tener un ID válido.");
        }
        validarDatos(cliente);
        return clienteDao.actualizar(cliente);
    }

    @Override
    public void eliminar(int id) {
        validarId(id);
        clienteDao.eliminar(id);
    }

    @Override
    public Cliente buscarPorId(int id) {
        validarId(id);
        return clienteDao.buscarPorId(id);
    }

    @Override
    public List<Cliente> listar() {
        return clienteDao.listar();
    }

    private void validarDatos(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (cliente.getTelefono() == null || !cliente.getTelefono().matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe contener exactamente 10 dígitos");
        }
        if (cliente.getCorreo() == null
                || !cliente.getCorreo().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
    }

    private void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }
}
