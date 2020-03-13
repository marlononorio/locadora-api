package com.marlononorio.locadora.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

public class Titulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TB_TITULO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TITULO")
    @SequenceGenerator(name = "SQ_TITULO", sequenceName = "SQ_TITULO", allocationSize = 1)
    private Long id;
}
