package com.pichincha.retocrudh2java.repository.crud;

import com.pichincha.retocrudh2java.entity.Cliente;
import com.pichincha.retocrudh2java.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteCrudRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT m.fecha,c.nombre as cliente, m.numerocuenta, c.tipocuenta, c.saldoInicial, c.estado, m.valor as movimiento, m.saldo as saldodisponible FROM CLIENTES c INNER JOIN CUENTAS cu ON cu.clienteid = c.clienteid INNER JOIN MOVIMIENTOS m ON m.cuentaid = c.cuentaid WHERE c.clienteid = ?1 AND m.fecha between ?2 AND ?3", nativeQuery = true)
    List<Reporte> reporte(Integer clienteid, Date fechainicial, Date fechafinal);



//    @Query(value = "SELECT m.fecha,c.nombre as cliente, m.numerocuenta, c.tipocuenta, c.saldoInicial, c.estado, m.valor as movimiento, m.saldo as saldodisponible FROM CLIENTES c INNER JOIN CUENTAS cu ON cu.clienteid = c.clienteid INNER JOIN MOVIMIENTOS m ON m.cuentaid = c.cuentaid WHERE c.clienteid = ?1 AND m.fecha between ?2 AND ?3", nativeQuery = true)

}
