package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.TituloDTO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/v1/titulos")
@RequiredArgsConstructor
public class TituloResource {

    private final BaseService<TituloDTO> tituloService;

    @PostMapping("/filter")
    public ResponseEntity<Page<TituloDTO>> findByFilter(@RequestBody TituloDTO dto, @ApiParam Pageable pageable) {
        Page<TituloDTO> titulo = tituloService.findByFilter(dto, pageable);
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TituloDTO dto) {
        tituloService.save(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tituloService.delete(id);
        return ResponseEntity.ok().build();
    }
}
