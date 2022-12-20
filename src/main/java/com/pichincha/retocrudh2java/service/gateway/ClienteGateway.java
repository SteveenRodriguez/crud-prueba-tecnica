package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.ClienteEntity;

import java.util.List;

public interface ClienteGateway {
    List<ClienteEntity> listarClientes();
    ClienteEntity guardarCliente(ClienteEntity clienteEntity);
    ClienteEntity obtenerClientePorId(Integer id);

    ClienteEntity actualizarCliente(ClienteEntity clienteEntity);

    void eliminarCliente(Integer id);
}
