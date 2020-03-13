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
}
