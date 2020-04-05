package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.ClasseDTO;
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
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClasseResource {

    private final BaseService<ClasseDTO> classeService;

    private static final String BASE_URL = "/api/v1/classes";
    private static final String ENTITY_NAME = "classes";
    private static final String APP_NAME = "Locadora PassaTempo";

    @PostMapping("/filter")
    public ResponseEntity<Page<ClasseDTO>> listar(@RequestBody ClasseDTO dto, @ApiParam Pageable pageable) {
        Page<ClasseDTO> classe = classeService.findAll(dto, pageable);
        return new ResponseEntity<>(classe, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClasseDTO> create(@RequestBody ClasseDTO dto) throws URISyntaxException {
        ClasseDTO result = classeService.save(dto);
        return ResponseEntity.created(new URI(BASE_URL + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, result.getId().toString(), ENTITY_NAME))
            .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> buscaPorId(@PathVariable Long id) {
        Optional<ClasseDTO> classe = classeService.findById(id);
        return ResponseUtil.wrapOrNotFound(classe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        classeService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
