package com.pichincha.retocrudh2java.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Reporte {
    private Date fecha; // TABLA MOVIMIENTOS
    private String cliente; // TABLA PERSONAS
    private String numeroCuenta; // TABLA CUENTA
    private String tipoCuenta; // TABLA CUENTA
    private Double saldoInicial; // TABLA CUENTA
    private Boolean estado; // TABLA CUENTA
    private Double movimiento; // TABLA MOVIMIENTO
    private Double saldoDisponible; // TABLA MOVIMIENTO
}
