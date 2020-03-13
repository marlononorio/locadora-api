package com.marlononorio.locadora.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Socio extends Cliente {

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "TELEFONE")
    private String telefone;
}
