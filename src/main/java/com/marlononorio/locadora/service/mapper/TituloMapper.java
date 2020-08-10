package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.service.dto.TituloDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TituloMapper {

    @Mapping(source = "idDiretor", target = "diretor.id")
    @Mapping(source = "idClasse", target = "classe.id")
    Titulo toEntity(TituloDTO dto);

    @Mapping(target = "idDiretor", source = "diretor.id")
    @Mapping(target = "idClasse", source = "classe.id")
    TituloDTO toDto(Titulo dto);
}
