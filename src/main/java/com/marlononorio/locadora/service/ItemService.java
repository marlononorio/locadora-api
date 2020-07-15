package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Item;
import com.marlononorio.locadora.repository.ItemRepository;
import com.marlononorio.locadora.service.dto.ItemDTO;
import com.marlononorio.locadora.service.dto.ItemListDTO;
import com.marlononorio.locadora.service.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public Boolean existsItemByTituloId(Long id) {
        return itemRepository.existsItemByTituloId(id);
    }

    public void save(ItemDTO dto) {
        log.debug("Request to save Item: {}", dto.getId());
        Item entity = itemMapper.toEntity(dto);
        itemRepository.save(entity);
    }

    public void delete(Long id) {
    }

    public Page<ItemListDTO> findByFilter(ItemListDTO dto, Pageable pageable) {
        return itemRepository.findAll(pageable).map(itemMapper::toListDto);
    }
}
