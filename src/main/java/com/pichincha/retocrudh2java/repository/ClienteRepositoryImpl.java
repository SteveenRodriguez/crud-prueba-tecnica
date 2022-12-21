package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Reporte;
import com.pichincha.retocrudh2java.repository.crud.ClienteCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteGateway {

    @Autowired
    private ClienteCrudRepository clienteRepository;

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente actualizarCliente(Cliente clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Reporte> reportes(Integer clienteid, Date fechainicial, Date fechafinal){
        return clienteRepository.reporte(clienteid, fechainicial, fechafinal);
    }

}
