package com.pichincha.retocrudh2java.controller;

import com.pichincha.retocrudh2java.entity.CuentaEntity;
import com.pichincha.retocrudh2java.service.CuentaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuentas")
    public ResponseEntity<List<CuentaEntity>> obtenerTodosLasCuentas() {
        log.info("Obteniendo todos las cuentas");
        return ResponseEntity.ok(cuentaService.listarCuentas());
    }

    @PostMapping("/cuentas")
    public ResponseEntity<CuentaEntity> guardarCuenta(@RequestBody() CuentaEntity cuentaEntity){
        log.info("Cuenta creada");
        return new ResponseEntity<>(cuentaService.guardarCuenta(cuentaEntity), HttpStatus.CREATED);
    }

    @GetMapping("/cuentas/{id}")
    public ResponseEntity<CuentaEntity> obtenerCuentaPorId(@PathVariable() Integer id) {
        log.info("Obteniendo cuenta por ID");
        return new ResponseEntity<>(cuentaService.obtenerCuentaPorId(id) ,HttpStatus.OK);
    }

    @PutMapping("/cuentas")
    public ResponseEntity<CuentaEntity> actualizarCuenta(@RequestBody() CuentaEntity cuentaEntity){
        log.info("Cuenta Actualizada");
        return new ResponseEntity<>(cuentaService.actualizarCuenta( cuentaEntity), HttpStatus.OK);
    }

    @DeleteMapping("/cuentas/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable() Integer id) {
        cuentaService.eliminarCuenta(id);
        log.info("Cuenta Eliminada");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
