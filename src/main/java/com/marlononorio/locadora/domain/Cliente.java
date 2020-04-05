package com.marlononorio.locadora.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@MappedSuperclass
public abstract class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ID = "ID";
    private static final String NOME = "NOME";
    private static final String DATA_NASCIMENTO = "DATA_NASCIMENTO";
    private static final String SEXO = "SEXO";
    private static final String STATUS = "STATUS";

    @Column(name = NOME)
    private String nome;

    @Column(name = DATA_NASCIMENTO)
    private LocalDateTime dtNascimento;

    @Column(name = SEXO)
    private String sexo;

    @Column(name = STATUS)
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL,
        orphanRemoval = true)
    private Set<Locacao> locacao;
}
