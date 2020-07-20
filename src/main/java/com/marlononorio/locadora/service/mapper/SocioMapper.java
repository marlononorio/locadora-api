package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Socio;
import com.marlononorio.locadora.service.dto.SocioDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SocioMapper {

    Socio toEntity(SocioDTO dto);

    SocioDTO toDto(Socio entity);

    @AfterMapping
    default void atualizarRelacionamentos(@MappingTarget Socio socio) {
        socio.getDependentes().forEach(dependente -> {
            dependente.setSocio(socio);
            dependente.setStatus(Boolean.TRUE);
        });
    }
}
