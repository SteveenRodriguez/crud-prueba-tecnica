package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.Movimiento;
import com.pichincha.retocrudh2java.repository.crud.MovimientoCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.MovimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovimientoRepositoryImpl implements MovimientoGateway {
    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;

    @Override
    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoCrudRepository.findAll();
    }

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        return movimientoCrudRepository.save(movimiento);
    }

    @Override
    public Movimiento obtenerMovimientoPorId(Integer id) {
        return movimientoCrudRepository.findById(id).get();
    }

    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return movimientoCrudRepository.save(movimiento);
    }

    @Override
    public void eliminarMovimiento(Integer id) {
        movimientoCrudRepository.deleteById(id);
    }


}
