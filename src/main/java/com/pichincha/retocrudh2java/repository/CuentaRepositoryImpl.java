package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.repository.crud.CuentaCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaRepositoryImpl implements CuentaGateway {

    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;
    @Override
    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaCrudRepository.findAll();
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuentaEntity) {
        return cuentaCrudRepository.save(cuentaEntity);
    }

    @Override
    public Cuenta obtenerCuentaPorId(Integer id) {
        return cuentaCrudRepository.findById(id).get();
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuentaEntity) {
        return cuentaCrudRepository.save(cuentaEntity);
    }

    @Override
    public void eliminarCuenta(Integer id) {
        cuentaCrudRepository.deleteById(id);
    }
}
