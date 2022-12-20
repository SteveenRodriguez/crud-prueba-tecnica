package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.ClienteEntity;
import com.pichincha.retocrudh2java.entity.CuentaEntity;

import java.util.List;

public interface CuentaGateway {
    List<CuentaEntity> listarCuentas();
    CuentaEntity guardarCuenta(CuentaEntity cuentaEntity);
    CuentaEntity obtenerCuentaPorId(Integer id);
    CuentaEntity actualizarCuenta(CuentaEntity cuentaEntity);
    void eliminarCuenta(Integer id);
}
