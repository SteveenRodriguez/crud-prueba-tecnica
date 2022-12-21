package com.pichincha.retocrudh2java.controller;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Reporte;
import com.pichincha.retocrudh2java.service.ClienteService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        if (clienteService.obtenerTodosLosClientes().isEmpty()) {
            log.info("No hay clientes para mostrar");
            return new ResponseEntity("No hay clientes para mostrar", HttpStatus.OK);
        }
        log.info("Obteniendo todos los clientes");
        return ResponseEntity.ok(clienteService.obtenerTodosLosClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente clienteEntity) {
        log.info("Cliente creado");
        return new ResponseEntity<>(clienteService.crearCliente(clienteEntity), HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable() Integer id) {
        log.info("Obteniendo cliente por ID");
        return new ResponseEntity<>(clienteService.obtenerClientePorId(id) ,HttpStatus.OK);
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody() Cliente clienteEntity){
        log.info("Cliente Actualizado");
        return new ResponseEntity<>(clienteService.actualizarCliente(clienteEntity), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> eliminarCLiente(@PathVariable() Integer id) {
        clienteService.eliminarCliente(id);
        log.info("Cliente Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/reportes/{id}")
    public ResponseEntity<List<Reporte>> reportes(
            @RequestParam String fechaInicial,
            @RequestParam String fechaFinal,
            @PathVariable() Integer id
    ) throws ParseException {
        Date inicial = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicial);
        Date dfinal = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFinal);
        log.info(inicial.toString());
        log.info(dfinal.toString());
        log.info("Obteniendo reporte de movimientos por cliente");
        return ResponseEntity.ok(clienteService.reportes(id, inicial, dfinal));
    }

}
