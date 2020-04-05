package com.marlononorio.locadora.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "TB_DEPENDENTE")
public class Dependente extends Cliente{

    private static final String ID_SOCIO = "SOCIO";
    private static final String ID_DEPENDENTE = "ID_DEPENDENTE";

    @Id
    @Column(name = ID_DEPENDENTE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SQ_CLIENTE", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = ID_SOCIO, nullable = false)
    private Socio socio;
}
