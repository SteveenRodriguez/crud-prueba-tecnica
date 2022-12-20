package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.CuentaEntity;
import com.pichincha.retocrudh2java.repository.crud.CuentaCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuentaRepositoryImp implements CuentaGateway {

    @Autowired
    private CuentaCrudRepository cuentaCrudRepository;
    @Override
    public List<CuentaEntity> listarCuentas() {
        return cuentaCrudRepository.findAll();
    }

    @Override
    public CuentaEntity guardarCuenta(CuentaEntity cuentaEntity) {
        return cuentaCrudRepository.save(cuentaEntity);
    }

    @Override
    public CuentaEntity obtenerCuentaPorId(Integer id) {
        return cuentaCrudRepository.findById(id).get();
    }

    @Override
    public CuentaEntity actualizarCuenta(CuentaEntity cuentaEntity) {
        return cuentaCrudRepository.save(cuentaEntity);
    }

    @Override
    public void eliminarCuenta(Integer id) {
        cuentaCrudRepository.deleteById(id);
    }
}
