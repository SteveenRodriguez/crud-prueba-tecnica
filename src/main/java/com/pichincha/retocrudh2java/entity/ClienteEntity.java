package com.pichincha.retocrudh2java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class ClienteEntity extends PersonaEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column
    private String clave;

    @Column
    private Boolean estado;

//    @OneToOne()
//    @JoinColumn(name = "persona_cliente")
//    private PersonaEntity personaEntity;

//    @OneToMany(mappedBy = "clienteEntity")
//    private List<CuentaEntity> cuentas;
}
