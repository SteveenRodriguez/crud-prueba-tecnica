package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Reporte;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteGateway clienteGateway;

    @Autowired
    private CuentaGateway cuentaGateway;

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteGateway.obtenerTodosLosClientes();
    }

    public Cliente crearCliente(Cliente clienteEntity) {
        Integer clienteId = (int)Math.floor(Math.random()*1000+1);
        clienteEntity.setClienteId(clienteId);
        return clienteGateway.crearCliente(clienteEntity);
    }

    public Cliente obtenerClientePorId(Integer id) {
        return clienteGateway.obtenerClientePorId(id);
    }

    public Cliente actualizarCliente(Cliente clienteEntity) {
        return clienteGateway.actualizarCliente(clienteEntity);
    }
    public void eliminarCliente(Integer id) {
        clienteGateway.eliminarCliente(id);
    }

    public List<Reporte> reportes(Integer clienteid, Date fechainicial, Date fechafinal) {
        return clienteGateway.reportes(clienteid, fechainicial, fechafinal);
    }

}
