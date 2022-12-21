package com.pichincha.retocrudh2java.controller;

import com.pichincha.retocrudh2java.entity.Movimiento;
import com.pichincha.retocrudh2java.service.MovimientoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> obtenerTodosLosMovimientos() {
        log.info("Obteniendo todos los movimientos");
        return ResponseEntity.ok(movimientoService.obtenerTodosLosMovimientos());
    }

    @PostMapping("/movimientos")
    public ResponseEntity<Object> crearMovimiento(@RequestBody() Movimiento movimiento) throws Exception {
            log.info("Movimiento realizado");
            return new ResponseEntity<>(movimientoService.crearMovimiento(movimiento), HttpStatus.CREATED);
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable() Integer id) {
        log.info("Obteniendo movimiento por ID");
        return new ResponseEntity<>(movimientoService.obtenerMovimientoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/movimientos")
    public ResponseEntity<Movimiento> actualizarMovimiento(@RequestBody() Movimiento movimiento) {
        log.info("Movimiento Actualizado");
        return new ResponseEntity<>(movimientoService.actualizarMovimiento(movimiento), HttpStatus.OK);
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable() Integer id) {
        movimientoService.eliminarMovimiento(id);
        log.info("Movimiento Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
