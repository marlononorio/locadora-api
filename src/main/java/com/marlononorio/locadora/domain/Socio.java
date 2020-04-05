package com.marlononorio.locadora.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "TB_SOCIO")
public class Socio extends Cliente{

    private static final String CPF = "CPF";
    private static final String ENDERECO = "ENDERECO";
    private static final String TELEFONE = "TELEFONE";
    private static final String ID_SOCIO = "SOCIO";

    @Id
    @Column(name = ID_SOCIO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
    @SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SQ_CLIENTE", allocationSize = 1)
    private Long id;

    @Column(name = CPF)
    private String cpf;

    @Column(name = ENDERECO)
    private String endereco;

    @Column(name = TELEFONE)
    private String telefone;
}
