package com.marlononorio.locadora.web.rest;

import com.marlononorio.locadora.service.DependenteService;
import com.marlononorio.locadora.service.dto.DependenteListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class DependenteResource {

    private final DependenteService dependenteService;

    @GetMapping("/dependentes/{id}")
    public ResponseEntity<List<DependenteListDTO>> findAllDependenteBySocioId(@PathVariable Long id){
        List<DependenteListDTO> result = dependenteService.findAllDependenteBySocioId(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/dependentes/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        dependenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
