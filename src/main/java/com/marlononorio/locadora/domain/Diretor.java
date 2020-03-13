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
@Table(name = "TB_DIRETOR")
public class Diretor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TB_DIRETOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DIRETOR")
    @SequenceGenerator(name = "SQ_DIRETOR", sequenceName = "SQ_DIRETOR", allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diretor diretor = (Diretor) o;
        return Objects.equals(id, diretor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}