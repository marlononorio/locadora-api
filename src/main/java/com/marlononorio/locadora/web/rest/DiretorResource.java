package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.DiretorService;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/diretores")
@RequiredArgsConstructor
public class DiretorResource {

    private final DiretorService diretorService;

    @PostMapping("/filter")
    public ResponseEntity<Page<DiretorDTO>> listar(@RequestBody DiretorDTO dto, @ApiParam Pageable pageable) {
        Page<DiretorDTO> diretor = diretorService.findByFilter(dto, pageable);
        return new ResponseEntity<>(diretor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DiretorDTO dto) {
        diretorService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorDTO> buscaPorId(@PathVariable Long id) {
        Optional<DiretorDTO> diretor = diretorService.findById(id);
        return ResponseUtil.wrapOrNotFound(diretor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diretorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/descricao")
    public ResponseEntity<List<ValueLabelDTO>> findDescricao(){
        List<ValueLabelDTO> result = diretorService.findDescricao();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/dropdown")
    public ResponseEntity<List<DiretorDTO>> dropdown(){
        List<DiretorDTO> result = diretorService.dropdown();
        return ResponseEntity.ok().body(result);
    }
}
