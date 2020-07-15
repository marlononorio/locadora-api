package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.ItemService;
import com.marlononorio.locadora.service.dto.ItemDTO;
import com.marlononorio.locadora.service.dto.ItemListDTO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController("/api/v1/itens")
@Slf4j
@RequiredArgsConstructor
public class ItemResource {

    private final ItemService itemService;

    @PostMapping("/filter")
    public ResponseEntity<Page<ItemListDTO>> findByFilter(@RequestBody ItemListDTO dto, @ApiParam Pageable pageable) {
        Page<ItemListDTO> itens = itemService.findByFilter(dto, pageable);
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ItemDTO dto) {
        itemService.save(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
