package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Dependente;
import com.marlononorio.locadora.service.dto.DependenteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DependenteMapper {

    @Mapping(source = "idSocio", target = "socio.id")
    Dependente toEntity(DependenteDTO dto);

    @Mapping(target = "idSocio", source = "socio.id")
    DependenteDTO toDto(Dependente entity);
}
