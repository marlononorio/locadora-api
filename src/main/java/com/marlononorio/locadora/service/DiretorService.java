package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Diretor;
import com.marlononorio.locadora.repository.DiretorRepository;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import com.marlononorio.locadora.service.mapper.DiretorMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DiretorService {

    private final Logger log = LoggerFactory.getLogger(AtorService.class);

    private final DiretorRepository diretorRepository;
    private final DiretorMapper diretorMapper;

    public DiretorDTO save(DiretorDTO diretor) {
        log.debug("Request to save Ncm : {}", diretor);
        Diretor entity = diretorMapper.toEntity(diretor);
        entity = diretorRepository.save(entity);
        return diretorMapper.toDto(entity);
    }

    public void delete(Long id) {
        log.debug("Request to delete Diretor : {}", id);
        diretorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<DiretorDTO> findById(Long id) {
        log.debug("Request to get Diretor : {}", id);
        return diretorRepository.findById(id)
            .map(diretorMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<DiretorDTO> findByFilter(DiretorDTO dto, Pageable pageable) {
        return diretorRepository.findByFilter(dto, pageable);
    }
}