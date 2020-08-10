package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Item;
import com.marlononorio.locadora.service.dto.ItemDTO;
import com.marlononorio.locadora.service.dto.ItemListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper{

    @Mapping(source = "entity.titulo.nome", target = "titulo")
    ItemListDTO toListDto(Item entity);

    @Mapping(target = "titulo", source = "titulo.id")
    ItemDTO toDto(Item entity);

    @Mapping(source = "titulo", target = "titulo.id")
    Item toEntity(ItemDTO dto);
}
