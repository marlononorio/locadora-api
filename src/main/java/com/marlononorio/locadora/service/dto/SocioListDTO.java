package com.marlononorio.locadora.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocioListDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String sexo;
    private String cpf;
    private LocalDateTime dtNascimento;
}
