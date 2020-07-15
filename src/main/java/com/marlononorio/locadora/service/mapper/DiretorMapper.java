package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Diretor;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiretorMapper {

    Diretor toEntity(DiretorDTO dto);
    DiretorDTO toDto(Diretor entity);
}
