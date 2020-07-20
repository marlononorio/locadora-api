package com.marlononorio.locadora.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DependenteDTO {

    private Long id;
    private String nome;
    private LocalDateTime dtNascimento;
    private String sexo;
    private String situacao;
    private Long idSocio;
}
