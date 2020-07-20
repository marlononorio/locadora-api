package com.marlononorio.locadora.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SocioDTO {

    private Long id;
    private String nome;
    private LocalDateTime dtNascimento;
    private String sexo;
    private Boolean status;
    private String cpf;
    private String endereco;
    private String telefone;
    private List<DependenteDTO> dependentes;
}
