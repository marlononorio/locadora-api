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
public class DependenteListDTO {

    private Long id;
    private String nome;
    private LocalDateTime dtNascimento;
    private String sexo;
    private Boolean status;
}
