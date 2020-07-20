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
    private static final String ID = "ID_LOCACAO";
    private static final String DATA_LOCACAO = "DATA_LOCACAO";
    private static final String DATA_DEVOLUCAO_PREVISTA = "DATA_DEVOLUCAO_PREVISTA";
    private static final String DATA_DEVOLUCAO_EFETIVA = "DATA_DEVOLUCAO_EFETIVA";
    private static final String VALOR_COBRADO = "VALOR_COBRADO";
    private static final String MULTA = "MULTA";
    private static final String ID_ITEM = "ID_ITEM";
    private static final String SQ_LOCACAO = "SQ_LOCACAO";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_LOCACAO)
    @SequenceGenerator(name = SQ_LOCACAO, sequenceName = SQ_LOCACAO, allocationSize = 1)
    private Long id;

    @Column(name = DATA_LOCACAO)
    private LocalDateTime dtLocacao;

    @Column(name = DATA_DEVOLUCAO_PREVISTA)
    private LocalDateTime dtDevolucaoPrevista;

    @Column(name = DATA_DEVOLUCAO_EFETIVA)
    private LocalDateTime dtDevolucaoEfetiva;

    @Column(name = VALOR_COBRADO)
    private Double valorCobrado;

    @Column(name = MULTA)
    private Double multaCobrada;

    @ManyToOne
    @JoinColumn(name = ID_ITEM, nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ID_SOCIO")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "ID_DEPENDENTE")
    private Dependente dependente;
}
