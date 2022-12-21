package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.entity.Movimiento;
import com.pichincha.retocrudh2java.service.gateway.MovimientoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class MovimientoServiceTest {

    @Mock
    private MovimientoGateway movimientoGateway;
    @InjectMocks
    private MovimientoService movimientoService;
    private Movimiento movimiento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        movimiento = new Movimiento();
        movimiento.setIdMovimiento(1);
        movimiento.setFecha(new Date());
        movimiento.setTipoMovimiento("RETIRO");
        movimiento.setValor(111.0);
        movimiento.setSaldoInicial(1000.0);
        movimiento.setSaldoDisponible(1000.0);
        movimiento.setCuenta(new Cuenta());
    }

    @Test
    void obtenerTodosLosMovimientos() {
        when(movimientoGateway.obtenerTodosLosMovimientos()).thenReturn(Arrays.asList(movimiento));
        assertNotNull(movimientoService.obtenerTodosLosMovimientos());
    }

    @Test
    void crearMovimiento() throws Exception {
        when(movimientoGateway.crearMovimiento(any(Movimiento.class))).thenReturn(movimiento);
        assertNotNull(movimientoService.crearMovimiento(new Movimiento()));
    }

    @Test
    void obtenerMovimientoPorId() {
        when(movimientoGateway.obtenerMovimientoPorId(movimiento.getIdMovimiento())).thenReturn(movimiento);
        assertNotNull(movimientoService.obtenerMovimientoPorId(movimiento.getIdMovimiento()));
    }

    @Test
    void actualizarMovimiento() {
        when(movimientoGateway.actualizarMovimiento(any(Movimiento.class))).thenReturn(movimiento);
        assertNotNull(movimientoService.actualizarMovimiento(new Movimiento()));
    }
}