package com.pichincha.retocrudh2java.controller;

import com.pichincha.retocrudh2java.entity.ClienteEntity;
import com.pichincha.retocrudh2java.service.ClienteService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Log
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteEntity>> obtenerTodosLosClientes() {
        log.info("Obteniendo todos los clientes");
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteEntity> guardarCliente(@RequestBody() ClienteEntity clienteEntity){
        log.info("Cliente creado");
        return new ResponseEntity<>(clienteService.guardarCliente(clienteEntity), HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteEntity> obtenerClientePorId(@PathVariable() Integer id) {
        log.info("Obteniendo cliente por ID");
        return new ResponseEntity<>(clienteService.obtenerClientePorId(id) ,HttpStatus.OK);
    }

    @PutMapping("/clientes")
    public ResponseEntity<ClienteEntity> actualizarCliente(@RequestBody() ClienteEntity clienteEntity){
        log.info("Cliente Actualizado");
        return new ResponseEntity<>(clienteService.actualizarCliente( clienteEntity), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> eliminarCLiente(@PathVariable() Integer id) {
        clienteService.eliminarCliente(id);
        log.info("Cliente Eliminado");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
