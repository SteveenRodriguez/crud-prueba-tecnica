package com.pichincha.retocrudh2java.service.gateway;

import com.pichincha.retocrudh2java.entity.CuentaEntity;
import com.pichincha.retocrudh2java.entity.MovimientoEntity;

import java.util.List;

public interface MovimientoGateway {
    List<MovimientoEntity> listarMovimientos();
    MovimientoEntity guardarMovimiento(MovimientoEntity movimientoEntity);
    MovimientoEntity obtenerMovimientoPorId(Integer id);
    MovimientoEntity actualizarMovimiento(MovimientoEntity movimientoEntity);
    void eliminarMovimiento(Integer id);
}
