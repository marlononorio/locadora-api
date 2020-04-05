package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.service.dto.ClasseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClasseMapper {
    Classe toEntity(ClasseDTO dto);

    ClasseDTO toDto(Classe entity);
}
