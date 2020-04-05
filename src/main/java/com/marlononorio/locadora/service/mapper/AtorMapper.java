package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.service.dto.AtorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AtorMapper {

    Ator toEntity(AtorDTO dto);

    AtorDTO toDto(Ator entity);
}
