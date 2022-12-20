package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.MovimientoEntity;
import com.pichincha.retocrudh2java.service.gateway.MovimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoGateway movimientoGateway;

    public List<MovimientoEntity> listarMovimientos() {
        return movimientoGateway.listarMovimientos();
    }

    public MovimientoEntity guardarMovimiento(MovimientoEntity movimientoEntity) {
        return movimientoGateway.guardarMovimiento(movimientoEntity);
    }

    public MovimientoEntity obtenerMovimientoPorId(Integer id) {
        return movimientoGateway.obtenerMovimientoPorId(id);
    }

    public MovimientoEntity actualizarMovimiento(MovimientoEntity movimientoEntity) {
        return movimientoGateway.actualizarMovimiento(movimientoEntity);
    }

    public void eliminarMovimiento(Integer id) {
        movimientoGateway.eliminarMovimiento(id);
    }
}
