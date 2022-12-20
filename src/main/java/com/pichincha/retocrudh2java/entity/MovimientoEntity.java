package com.pichincha.retocrudh2java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "movimientos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class MovimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Column
    private String fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Column
    private Double valor;

    @Column
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "movimiento_cuenta")
    private CuentaEntity cuentaEntity;

}
