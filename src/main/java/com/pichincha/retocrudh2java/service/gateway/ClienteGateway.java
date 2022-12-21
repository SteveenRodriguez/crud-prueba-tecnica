package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Reporte;

import java.util.Date;
import java.util.List;

public interface ClienteGateway {
    List<Cliente> obtenerTodosLosClientes();
    Cliente crearCliente(Cliente clienteEntity);
    Cliente obtenerClientePorId(Integer id);

    Cliente actualizarCliente(Cliente clienteEntity);

    void eliminarCliente(Integer id);

    List<Reporte> reportes (Integer clienteid, Date fechainicial, Date fechafinal);
}
