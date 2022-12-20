package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.ClienteEntity;
import com.pichincha.retocrudh2java.entity.CuentaEntity;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaGateway cuentaGateway;

    public List<CuentaEntity> listarCuentas() {
        return cuentaGateway.listarCuentas();
    }

    public CuentaEntity guardarCuenta(CuentaEntity  cuentaEntity) {
        return cuentaGateway.guardarCuenta(cuentaEntity);
    }

    public CuentaEntity obtenerCuentaPorId(Integer id) {
        return cuentaGateway.obtenerCuentaPorId(id);
    }

    public CuentaEntity actualizarCuenta(CuentaEntity cuentaEntity) {
        return cuentaGateway.actualizarCuenta(cuentaEntity);
    }
    public void eliminarCuenta(Integer id) {
        cuentaGateway.eliminarCuenta(id);
    }
}
