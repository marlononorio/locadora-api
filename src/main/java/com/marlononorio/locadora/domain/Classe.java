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
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "TB_CLASSE")
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TB_CLASSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLASSE")
    @SequenceGenerator(name = "SQ_CLASSE", sequenceName = "SQ_CLASSE", allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "DATA_DEVOLUCAO", nullable = false)
    private LocalDateTime dtDevolucao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return Objects.equals(id, classe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
