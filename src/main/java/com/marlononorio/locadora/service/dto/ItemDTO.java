package com.marlononorio.locadora.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private LocalDateTime dtAquisicao;
    private String tipo;
    private String numeroSerie;
    private Long titulo;
}
