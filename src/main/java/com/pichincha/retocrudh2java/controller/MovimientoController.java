package com.pichincha.retocrudh2java.controller;

import com.pichincha.retocrudh2java.entity.CuentaEntity;
import com.pichincha.retocrudh2java.entity.MovimientoEntity;
import com.pichincha.retocrudh2java.service.MovimientoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public ResponseEntity<List<MovimientoEntity>> obtenerTodosLosMovimientos() {
        log.info("Obteniendo todos los movimientos");
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }

    @PostMapping("/movimientos")
    public ResponseEntity<MovimientoEntity> guardarMovimiento(@RequestBody() MovimientoEntity movimientoEntity) {
        log.info("Movimiento creado");
        return new ResponseEntity<>(movimientoService.guardarMovimiento(movimientoEntity), HttpStatus.CREATED);
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<MovimientoEntity> obtenerMovimientoPorId(@PathVariable() Integer id) {
        log.info("Obteniendo movimiento por ID");
        return new ResponseEntity<>(movimientoService.obtenerMovimientoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/movimientos")
    public ResponseEntity<MovimientoEntity> actualizarMovimiento(@RequestBody() MovimientoEntity movimientoEntity) {
        log.info("Movimiento Actualizado");
        return new ResponseEntity<>(movimientoService.actualizarMovimiento(movimientoEntity), HttpStatus.OK);
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable() Integer id) {
        movimientoService.eliminarMovimiento(id);
        log.info("Movimiento Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
