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

    @Id
    @Column(name = "ID_ATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ATOR")
    @SequenceGenerator(name = "SQ_ATOR", sequenceName = "SQ_ATOR", allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ator ator = (Ator) o;
        return Objects.equals(id, ator.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
