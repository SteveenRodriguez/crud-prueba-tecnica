package com.pichincha.retocrudh2java.service;

import com.pichincha.retocrudh2java.entity.Cuenta;
import com.pichincha.retocrudh2java.entity.Movimiento;
import com.pichincha.retocrudh2java.entity.Reporte;
import com.pichincha.retocrudh2java.service.gateway.ClienteGateway;
import com.pichincha.retocrudh2java.service.gateway.CuentaGateway;
import com.pichincha.retocrudh2java.service.gateway.MovimientoGateway;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class MovimientoService {

    @Autowired
    private MovimientoGateway movimientoGateway;

    @Autowired
    private CuentaGateway cuentaGateway;
    @Autowired
    private ClienteGateway clienteGateway;

    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoGateway.obtenerTodosLosMovimientos();
    }

    public Movimiento crearMovimiento(Movimiento movimiento) throws Exception {
        Cuenta cuenta = cuentaGateway.obtenerCuentaPorId(movimiento.getCuenta().getCuentaId());
        Double saldoCuentaAcutal = cuenta.getSaldoInicial();
        Double valor = movimiento.getValor();
        movimiento.setSaldoInicial(saldoCuentaAcutal);
        Double nuevoSaldo = 0.0;
        if (saldoCuentaAcutal < valor && movimiento.getTipoMovimiento().equals("RETIRO")) {
            throw new Exception("Saldo Insuficiente");
        }
        if (movimiento.getTipoMovimiento().equals("RETIRO")) {
            nuevoSaldo = saldoCuentaAcutal - valor;
        }
        if (movimiento.getTipoMovimiento().equals("DEPOSITO")) {
            nuevoSaldo = saldoCuentaAcutal + valor;
        }
        cuenta.setSaldoInicial(nuevoSaldo);
        movimiento.setSaldoDisponible(nuevoSaldo);
        return movimientoGateway.crearMovimiento(movimiento);
    }

    public Movimiento obtenerMovimientoPorId(Integer id) {
        return movimientoGateway.obtenerMovimientoPorId(id);
    }

    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        return movimientoGateway.actualizarMovimiento(movimiento);
    }

    public void eliminarMovimiento(Integer id) {
        movimientoGateway.eliminarMovimiento(id);
    }

    public List<Reporte> reportes(Integer id) {
        List<Reporte> reportes = new ArrayList<>();
        var clienteEncontrado = clienteGateway.obtenerClientePorId(id);

        Reporte reporte = Reporte.builder()
                .cliente(clienteEncontrado.getNombre())
                .build();

        reportes.add(reporte);
        return reportes;
    }
}
