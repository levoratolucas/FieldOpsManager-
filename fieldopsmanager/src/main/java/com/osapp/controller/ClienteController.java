package com.osapp.controller;

import com.osapp.model.Cliente;
import com.osapp.service.ClienteService;

import java.util.List;

public class ClienteController {

    private final ClienteService service = new ClienteService();

    public void adicionarCliente(Cliente cliente) {
        service.adicionarCliente(cliente.getName(), cliente);
    }

    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }

    public void atualizarCliente(Cliente cliente) {
        service.atualizarCliente(cliente);
    }

    public void deletarCliente(Long id) {
        service.deletarCliente(id);
    }
}
