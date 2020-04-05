package com.marlononorio.locadora.domain;

import com.marlononorio.locadora.enumeration.TipoCategoriaEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "TB_TITULO")
public class Titulo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ID = "ID_TITULO";
    private static final String NOME = "NOME";
    private static final String ANO = "ANO";
    private static final String SINOPSE = "SINOPSE";
    private static final String CATEGORIA = "CATEGORIA";
    private static final String ID_DIRETOR = "ID_DIRETOR";
    private static final String ID_CLASSE = "ID_CLASSE";
    private static final String SQ_TITULO = "SQ_TITULO";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_TITULO)
    @SequenceGenerator(name = SQ_TITULO, sequenceName = SQ_TITULO, allocationSize = 1)
    private Long id;

    @Column(name = NOME, nullable = false)
    private String nome;

    @Column(name = ANO, nullable = false)
    private String ano;

    @Column(name = SINOPSE, nullable = false)
    private String sinopse;

    @Enumerated(EnumType.STRING)
    @Column(name = CATEGORIA)
    private TipoCategoriaEnum categoria;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Ator> atores;

    @ManyToOne
    @JoinColumn(name = ID_DIRETOR, nullable = false)
    private Diretor diretor;

    @ManyToOne
    @JoinColumn(name = ID_CLASSE, nullable = false)
    private Classe classe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titulo titulo = (Titulo) o;
        return Objects.equals(id, titulo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
