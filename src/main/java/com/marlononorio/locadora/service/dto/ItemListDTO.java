package com.marlononorio.locadora.service.dto;

import com.marlononorio.locadora.enumeration.TipoItemEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ItemListDTO {

    private Long id;
    private String titulo;
    private LocalDateTime dtAquisicao;
    private String tipo;

    public ItemListDTO(Long id, String titulo, LocalDateTime dtAquisicao, TipoItemEnum tipo) {
        this.id = id;
        this.titulo = titulo;
        this.dtAquisicao = dtAquisicao;
        this.tipo = tipo.getDescricao();
    }
}
