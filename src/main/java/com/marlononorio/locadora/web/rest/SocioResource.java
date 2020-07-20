package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.SocioService;
import com.marlononorio.locadora.service.dto.SocioDTO;
import com.marlononorio.locadora.service.dto.SocioListDTO;
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

@RestController
@RequestMapping("/api/v1/socios")
@RequiredArgsConstructor
@Slf4j
public class SocioResource {

    private final SocioService socioService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SocioDTO dto) {
        socioService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<Page<SocioListDTO>> listar(@RequestBody SocioListDTO dto, Pageable pageable) {
        Page<SocioListDTO> ator = socioService.findByFilter(dto, pageable);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocioById(@PathVariable Long id){
        socioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
