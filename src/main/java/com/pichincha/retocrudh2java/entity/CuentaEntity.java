package com.pichincha.retocrudh2java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity(name = "cuentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Integer cuentaId;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo_inicial")
    private Double saldoInicial;

    @Column
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "cuenta_cliente")
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy = "cuentaEntity")
    private List<MovimientoEntity> movimientos;
}
