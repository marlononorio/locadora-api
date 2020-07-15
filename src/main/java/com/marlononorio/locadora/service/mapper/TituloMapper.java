package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.service.dto.TituloDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TituloMapper extends BaseMapper<Titulo, TituloDTO>{
}
