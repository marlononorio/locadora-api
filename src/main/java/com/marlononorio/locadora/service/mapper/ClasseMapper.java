package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.service.dto.ClasseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClasseMapper extends BaseMapper<Classe, ClasseDTO>{
}
