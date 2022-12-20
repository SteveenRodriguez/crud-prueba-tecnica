package com.pichincha.retocrudh2java.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column
    private String nombre;

    @Column
    private String genero;

    @Column
    private String edad;

    @Column
    private Integer identificacion;

    @Column
    private String direccion;

    @Column
    private String telefono;

//    @OneToOne(cascade = {CascadeType.ALL})
//    private ClienteEntity clienteEntity;
}
