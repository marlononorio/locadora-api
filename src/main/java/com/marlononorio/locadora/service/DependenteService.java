package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Dependente;
import com.marlononorio.locadora.repository.DependenteRepository;
import com.marlononorio.locadora.service.dto.DependenteDTO;
import com.marlononorio.locadora.service.dto.DependenteListDTO;
import com.marlononorio.locadora.service.mapper.DependenteMapper;
import com.marlononorio.locadora.web.rest.errors.BadRequestAlertException;
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
    private final DependenteMapper dependenteMapper;

    public List<DependenteListDTO> findAllDependenteBySocioId(Long id){
        return dependenteRepository.findAllBySocioId(id);
    }

    public void deleteById(Long id) {
        dependenteRepository.deleteById(id);
    }

    public Boolean existsBySocioId(Long id){
        return dependenteRepository.existsBySocioId(id);
    }

    public void update(DependenteDTO dependenteDTO) {
        if(dependenteRepository.existsByNome(dependenteDTO.getNome())) {
            throw new BadRequestAlertException("Dependente já existe", "Dependente já existe", "Dependente já existe");
        }
        dependenteRepository.update(dependenteDTO);
    }

    public void save(DependenteDTO dependenteDTO) {
        if(dependenteRepository.existsByNome(dependenteDTO.getNome())) {
            throw new BadRequestAlertException("Dependente já existe", "Dependente já existe", "Dependente já existe");
        }
        Dependente entity = dependenteMapper.toEntity(dependenteDTO);
        entity.setStatus(Boolean.TRUE);
        dependenteRepository.save(entity);
    }
}
