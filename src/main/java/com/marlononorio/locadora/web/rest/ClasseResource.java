package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.ClasseService;
import com.marlononorio.locadora.service.dto.ClasseDTO;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClasseResource {

    private final ClasseService classeService;

    @PostMapping("/filter")
    public ResponseEntity<Page<ClasseDTO>> findByFilter(@RequestBody ClasseDTO dto, @ApiParam Pageable pageable) {
        Page<ClasseDTO> classe = classeService.findByFilter(dto, pageable);
        return new ResponseEntity<>(classe, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ClasseDTO dto) {
        classeService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> buscaPorId(@PathVariable Long id) {
        Optional<ClasseDTO> classe = classeService.findById(id);
        return ResponseUtil.wrapOrNotFound(classe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/descricao")
    public ResponseEntity<List<ValueLabelDTO>> findAllClasseDescricao() {
        List<ValueLabelDTO> classes = classeService.findDescricao();
        return ResponseEntity.ok().body(classes);
    }

    @GetMapping("/dropdown")
    public ResponseEntity<List<ClasseDTO>> dropdown(){
        List<ClasseDTO> result = classeService.dropdown();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping
    public ResponseEntity<Void> updateAtor(@RequestBody ClasseDTO dto) {
        classeService.update(dto);
        return ResponseEntity.noContent().build();
    }
}
