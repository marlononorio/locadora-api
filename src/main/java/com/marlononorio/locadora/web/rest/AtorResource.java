package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.AtorDTO;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/atores")
@RequiredArgsConstructor
public class AtorResource {

    private final BaseService<AtorDTO> atorService;

    private static final String BASE_URL = "/api/v1/atores";
    private static final String ENTITY_NAME = "atores";
    private static final String APP_NAME = "Locadora PassaTempo";

    @PostMapping("/filter")
    public ResponseEntity<Page<AtorDTO>> listar(@RequestBody AtorDTO dto, @ApiParam Pageable pageable) {
        Page<AtorDTO> ator = atorService.findAll(dto, pageable);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AtorDTO> create(@RequestBody AtorDTO dto) throws URISyntaxException {
        AtorDTO result = atorService.save(dto);
        return ResponseEntity.created(new URI(BASE_URL + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, result.getId().toString(), ENTITY_NAME))
            .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtorDTO> buscaPorId(@PathVariable Long id) {
        Optional<AtorDTO> ator = atorService.findById(id);
        return ResponseUtil.wrapOrNotFound(ator);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        atorService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
