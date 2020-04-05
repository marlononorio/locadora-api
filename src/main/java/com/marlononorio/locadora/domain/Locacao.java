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
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "TB_LOCACAO")
public class Locacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TB_LOCACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOCACAO")
    @SequenceGenerator(name = "SQ_LOCACAO", sequenceName = "SQ_LOCACAO", allocationSize = 1)
    private Long id;

    @Column(name = "DATA_LOCACAO")
    private LocalDateTime dtLocacao;

    @Column(name = "DATA_DEVOLUCAO_PREVISTA")
    private LocalDateTime dtDevolucaoPrevista;

    @Column(name = "DATA_DEVOLUCAO_EFETIVA")
    private LocalDateTime dtDevolucaoEfetiva;

    @Column(name = "VALOR_COBRADO")
    private Double valorCobrado;

    @Column(name = "MULTA")
    private Double multaCobrada;

    @ManyToOne
    @JoinColumn(name = "ID_ITEM", nullable = false)
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locacao locacao = (Locacao) o;
        return Objects.equals(id, locacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
