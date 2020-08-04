package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.service.dto.TituloDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TituloMapper {

    Titulo toEntity(TituloDTO dto);

    TituloDTO toDto(Titulo entity);
}
