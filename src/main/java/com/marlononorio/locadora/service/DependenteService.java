package com.marlononorio.locadora.service;

import com.marlononorio.locadora.repository.DependenteRepository;
import com.marlononorio.locadora.service.dto.DependenteListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DependenteService {

    private final DependenteRepository dependenteRepository;

    public List<DependenteListDTO> findAllDependenteBySocioId(Long id){
        return dependenteRepository.findAllBySocioId(id);
    }

    public void deleteById(Long id) {
        dependenteRepository.deleteById(id);
    }

    public Boolean existsBySocioId(Long id){
        return dependenteRepository.existsBySocioId(id);
    }
}
