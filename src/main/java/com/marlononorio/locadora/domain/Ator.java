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
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "TB_ATOR")
public class Ator implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ID = "ID_ATOR";
    private static final String NOME = "NOME";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATOR")
    @SequenceGenerator(name = "SQ_ATOR", sequenceName = "SQ_ATOR", allocationSize = 1)
    private Long id;

    @Column(name = NOME, nullable = false)
    private String nome;
}
