package com.marlononorio.locadora.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dependente extends Cliente{

    @ManyToOne
    @JoinColumn(name = "ID_SOCIO", nullable = false)
    private Socio socio;
}
