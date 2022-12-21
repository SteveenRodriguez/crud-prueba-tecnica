package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class ClienteServiceTest {
    @Mock
    private ClienteGateway clienteGateway;
    @InjectMocks
    private ClienteService clienteService;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        cliente = new Cliente();
        cliente.setIdPersona(1);
        cliente.setNombre("Steveen");
        cliente.setGenero("MASCULINO");
        cliente.setEdad("26");
        cliente.setIdentificacion(1234567);
        cliente.setDireccion("avenida 10 con calle 12");
        cliente.setTelefono("312453554");
        cliente.setClienteId(332);
        cliente.setClave("1234");
        cliente.setEstado(true);
    }

    @Test
    void obtenerTodosLosClientes() {
        when(clienteGateway.obtenerTodosLosClientes()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.obtenerTodosLosClientes());
    }

    @Test
    void crearCliente() {
        when(clienteGateway.crearCliente(any(Cliente.class))).thenReturn(cliente);
        assertNotNull(clienteService.crearCliente(new Cliente()));
    }

    @Test
    void obtenerClientePorId() {
        when(clienteGateway.obtenerClientePorId(cliente.getIdPersona())).thenReturn(cliente);
        assertNotNull(clienteService.obtenerClientePorId(cliente.getIdPersona()));
    }

    @Test
    void actualizarCliente() {
        when(clienteGateway.actualizarCliente(any(Cliente.class))).thenReturn(cliente);
        assertNotNull(clienteService.actualizarCliente(new Cliente()));
    }
}