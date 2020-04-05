package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.DiretorDTO;
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
@RequestMapping("/api/v1/diretores")
@RequiredArgsConstructor
public class DiretorResource {

    private final BaseService<DiretorDTO> diretorService;

    private static final String BASE_URL = "/api/v1/diretores";
    private static final String ENTITY_NAME = "diretores";
    private static final String APP_NAME = "Locadora PassaTempo";

    @PostMapping("/filter")
    public ResponseEntity<Page<DiretorDTO>> listar(@RequestBody DiretorDTO dto, @ApiParam Pageable pageable) {
        Page<DiretorDTO> diretor = diretorService.findAll(dto, pageable);
        return new ResponseEntity<>(diretor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DiretorDTO> create(@RequestBody DiretorDTO dto) throws URISyntaxException {
        DiretorDTO result = diretorService.save(dto);
        return ResponseEntity.created(new URI(BASE_URL + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, result.getId().toString(), ENTITY_NAME))
            .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscaPorId(@PathVariable Long id) {
        Optional<DiretorDTO> diretor = diretorService.findById(id);
        return ResponseUtil.wrapOrNotFound(diretor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        diretorService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityCreationAlert(APP_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
