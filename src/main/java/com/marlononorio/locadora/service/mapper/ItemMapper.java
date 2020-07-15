package com.marlononorio.locadora.service.mapper;

import com.marlononorio.locadora.domain.Item;
import com.marlononorio.locadora.service.dto.ItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends BaseMapper<Item, ItemDTO>{
}
