package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.AtorService;
import com.marlononorio.locadora.service.dto.AtorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/atores")
@RequiredArgsConstructor
@Slf4j
public class AtorResource {

    private final AtorService atorService;

    @PostMapping("/filter")
    public ResponseEntity<Page<AtorDTO>> listar(@RequestBody AtorDTO dto, @ApiParam Pageable pageable) {
        Page<AtorDTO> ator = atorService.findByFilter(dto, pageable);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AtorDTO dto) {
        log.debug("REST request to save Ator : {}", dto);
        atorService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorDTO> buscaPorId(@PathVariable Long id) {
        Optional<AtorDTO> ator = atorService.findById(id);
        return ResponseUtil.wrapOrNotFound(ator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        atorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/descricao")
    public ResponseEntity<List<ValueLabelDTO>> findAllClasseDescricao() {
        List<ValueLabelDTO> ator = atorService.findDescricao();
        return ResponseEntity.ok().body(ator);
    }

    @GetMapping("/dropdown")
    public ResponseEntity<List<AtorDTO>> dropdown() {
        List<AtorDTO> ator = atorService.dropdown();
        return ResponseEntity.ok().body(ator);
    }
}
