package com.marlononorio.locadora.service.dto;

import com.marlononorio.locadora.enumeration.TipoCategoriaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TituloDTO {

    private Long id;
    private String nome;
    private String diretor;
    private String ano;
    private String categoria;
    private String classe;

    public TituloDTO(Long id, String nome, String diretor,
                     String ano, TipoCategoriaEnum categoria, String classe) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.categoria = categoria.getDescricao();
        this.classe = classe;
    }
}
