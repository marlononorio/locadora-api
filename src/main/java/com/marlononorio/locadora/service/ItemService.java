package com.marlononorio.locadora.service;

import com.marlononorio.locadora.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Boolean existsItemByTituloId(Long id) {
        return itemRepository.existsItemByTituloId(id);
    }
}
