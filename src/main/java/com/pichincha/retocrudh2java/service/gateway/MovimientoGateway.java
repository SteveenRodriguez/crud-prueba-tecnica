package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.Movimiento;

import java.util.List;

public interface MovimientoGateway {
    List<Movimiento> obtenerTodosLosMovimientos();
    Movimiento crearMovimiento(Movimiento movimiento);
    Movimiento obtenerMovimientoPorId(Integer id);
    Movimiento actualizarMovimiento(Movimiento movimiento);
    void eliminarMovimiento(Integer id);
}
