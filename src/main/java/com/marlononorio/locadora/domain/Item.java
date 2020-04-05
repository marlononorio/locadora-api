package com.marlononorio.locadora.domain;

import com.marlononorio.locadora.enumeration.TipoItemEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "TB_ITEM")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ID = "ID_ITEM";
    private static final String DATA_AQUISICAO = "DATA_AQUISICAO";
    private static final String TIPO = "TIPO";
    private static final String ID_TITULO = "ID_DIRETOR";
    private static final String SQ_ITEM = "SQ_ITEM";

    @Id
    @Column(name = ID)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_ITEM)
    @SequenceGenerator(name = SQ_ITEM, sequenceName = SQ_ITEM, allocationSize = 1)
    private Long id;

    @Column(name = DATA_AQUISICAO)
    private LocalDateTime dtAquisicao;

    @Enumerated(EnumType.STRING)
    @Column(name = TIPO)
    private TipoItemEnum tipo;

    @ManyToOne
    @JoinColumn(name = ID_TITULO, nullable = false)
    private Titulo titulo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
