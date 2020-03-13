package com.marlononorio.locadora.enumeration;

import lombok.Getter;

@Getter
public enum TipoItemEnum {

    FITA("Fita"),
    DVD("DVD"),
    BLU_RAY("Blu-ray");

    private String descricao;

    TipoItemEnum(String descricao){
        this.descricao = descricao;
    }
}
