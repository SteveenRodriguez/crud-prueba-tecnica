package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaGateway cuentaGateway;
    @Autowired
    private ClienteGateway clienteGateway;

    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaGateway.obtenerTodasLasCuentas();
    }

    public Cuenta crearCuenta( Cuenta cuenta) {
        return cuentaGateway.crearCuenta(cuenta);
    }

    public Cuenta obtenerCuentaPorId(Integer id) {
        return cuentaGateway.obtenerCuentaPorId(id);
    }

    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return cuentaGateway.actualizarCuenta(cuenta);
    }
    public void eliminarCuenta(Integer id) {
        cuentaGateway.eliminarCuenta(id);
    }
}
