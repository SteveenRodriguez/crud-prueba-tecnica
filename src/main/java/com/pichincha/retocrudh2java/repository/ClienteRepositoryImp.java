package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.ClienteEntity;
import com.pichincha.retocrudh2java.repository.crud.ClienteCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImp implements ClienteGateway {

    @Autowired
    private ClienteCrudRepository clienteRepository;

    @Override
    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity guardarCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public ClienteEntity obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public ClienteEntity actualizarCliente(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }


}
