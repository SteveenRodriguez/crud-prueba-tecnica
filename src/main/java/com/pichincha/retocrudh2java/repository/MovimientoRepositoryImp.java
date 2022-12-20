package com.pichincha.retocrudh2java.repository;

import com.pichincha.retocrudh2java.entity.MovimientoEntity;
import com.pichincha.retocrudh2java.repository.crud.MovimientoCrudRepository;
import com.pichincha.retocrudh2java.service.gateway.MovimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovimientoRepositoryImp implements MovimientoGateway {
    @Autowired
    private MovimientoCrudRepository movimientoCrudRepository;

    @Override
    public List<MovimientoEntity> listarMovimientos() {
        return movimientoCrudRepository.findAll();
    }

    @Override
    public MovimientoEntity guardarMovimiento(MovimientoEntity movimientoEntity) {
        return movimientoCrudRepository.save(movimientoEntity);
    }

    @Override
    public MovimientoEntity obtenerMovimientoPorId(Integer id) {
        return movimientoCrudRepository.findById(id).get();
    }

    @Override
    public MovimientoEntity actualizarMovimiento(MovimientoEntity movimientoEntity) {
        return movimientoCrudRepository.save(movimientoEntity);
    }

    @Override
    public void eliminarMovimiento(Integer id) {
        movimientoCrudRepository.deleteById(id);
    }
}
