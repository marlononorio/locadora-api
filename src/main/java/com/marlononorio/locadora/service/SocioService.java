package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Socio;
import com.marlononorio.locadora.repository.SocioRepository;
import com.marlononorio.locadora.service.dto.SocioDTO;
import com.marlononorio.locadora.service.dto.SocioListDTO;
import com.marlononorio.locadora.service.mapper.SocioMapper;
import com.marlononorio.locadora.web.rest.errors.BadRequestAlertException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SocioService {

    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;
    private final DependenteService dependenteService;

    public void save(SocioDTO dto) {

        if (dto.getId() != null){
            throw new BadRequestAlertException("Usuario duplicado", "Usuario duplicado", "Usuario duplicado");
        }
        Socio socio = socioMapper.toEntity(dto);
        socio.setStatus(Boolean.TRUE);
        socioRepository.saveAndFlush(socio);
    }

    public Page<SocioListDTO> findByFilter(SocioListDTO dto, Pageable pageable) {
        return socioRepository.findAllSocios(pageable);
    }

    public void deleteById(Long id) {

        if(dependenteService.existsBySocioId(id)) {
            throw new BadRequestAlertException("Existem dependentes vinculados!","Existem dependentes vinculados!", "Existem dependentes vinculados!");
        }
        socioRepository.deleteById(id);
    }
}
