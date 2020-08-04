package com.marlononorio.locadora.service.dto;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.domain.Diretor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class TituloDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String ano;
    private String categoria;
    private Diretor diretor;
    private Classe classe;
    private String sinopse;
    List<Ator> atores;
}
