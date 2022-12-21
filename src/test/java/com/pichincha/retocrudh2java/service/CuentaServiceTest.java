package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class CuentaServiceTest {
    @Mock
    private CuentaGateway cuentaGateway;
    @InjectMocks
    private CuentaService cuentaService;

    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cuenta = new Cuenta();
        cuenta.setCuentaId(1);
        cuenta.setSaldoInicial(2000.0);
        cuenta.setTipoCuenta("AHORROS");
        cuenta.setNumeroCuenta("443245");
        cuenta.setCliente(new Cliente());
        cuenta.setEstado(true);
    }

    @Test
    void obtenerTodasLasCuentas() {
        when(cuentaGateway.obtenerTodasLasCuentas()).thenReturn(Arrays.asList(cuenta));
        assertNotNull(cuentaService.obtenerTodasLasCuentas());
    }

    @Test
    void crearCuenta() {
        when(cuentaGateway.crearCuenta(any(Cuenta.class))).thenReturn(cuenta);
        assertNotNull(cuentaService.crearCuenta(new Cuenta()));
    }

    @Test
    void obtenerCuentaPorId() {
        when(cuentaGateway.obtenerCuentaPorId(cuenta.getCuentaId())).thenReturn(cuenta);
        assertNotNull(cuentaService.obtenerCuentaPorId(cuenta.getCuentaId()));
    }

    @Test
    void actualizarCuenta() {
        when(cuentaGateway.actualizarCuenta(any(Cuenta.class))).thenReturn(cuenta);
        assertNotNull(cuentaService.actualizarCuenta(new Cuenta()));
    }

}