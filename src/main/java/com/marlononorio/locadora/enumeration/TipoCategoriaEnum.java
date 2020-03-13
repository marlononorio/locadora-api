package com.marlononorio.locadora.enumeration;

import lombok.Getter;

@Getter
public enum TipoCategoriaEnum {

    COMEDIA("Comédia"),
    ACAO("Ação"),
    DRAMA("Drama"),
    TERROR("Terror"),
    AVENTURA("Aventura"),
    FICCAO("Ficção"),
    ANIMACAO("Animação"),
    DOCUMENTARIO("Documentário");

    private String descricao;

    TipoCategoriaEnum(String descricao){
        this.descricao = descricao;
    }
}
