package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.ClienteEntity;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteGateway clienteGateway;

    public List<ClienteEntity> listarClientes() {
        return clienteGateway.listarClientes();
    }

    public ClienteEntity guardarCliente(ClienteEntity clienteEntity) {
        return clienteGateway.guardarCliente(clienteEntity);
    }

    public ClienteEntity obtenerClientePorId(Integer id) {
        return clienteGateway.obtenerClientePorId(id);
    }

    public ClienteEntity actualizarCliente(ClienteEntity clienteEntity) {
        return clienteGateway.actualizarCliente(clienteEntity);
    }
    public void eliminarCliente(Integer id) {
        clienteGateway.eliminarCliente(id);
    }
}
