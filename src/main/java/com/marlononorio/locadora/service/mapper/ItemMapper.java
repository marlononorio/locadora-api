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

    ItemDTO toDto(Item entity);

    Item toEntity(ItemDTO entity);
}
