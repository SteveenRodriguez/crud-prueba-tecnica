package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.Cuenta;

import java.util.List;

public interface CuentaGateway {
    List<Cuenta> obtenerTodasLasCuentas();
    Cuenta crearCuenta(Cuenta cuentaEntity);
    Cuenta obtenerCuentaPorId(Integer id);
    Cuenta actualizarCuenta(Cuenta cuentaEntity);
    void eliminarCuenta(Integer id);
}
