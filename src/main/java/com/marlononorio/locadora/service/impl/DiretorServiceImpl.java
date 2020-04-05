package com.marlononorio.locadora.service.impl;

import com.marlononorio.locadora.domain.Diretor;
import com.marlononorio.locadora.repository.DiretorRepository;
import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import com.marlononorio.locadora.service.mapper.BaseMapper;
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
public class DiretorServiceImpl implements BaseService<DiretorDTO> {

    private final Logger log = LoggerFactory.getLogger(AtorServiceImpl.class);

    private final DiretorRepository diretorRepository;
    private final BaseMapper<Diretor, DiretorDTO> diretorMapper;

    @Override
    public DiretorDTO save(DiretorDTO diretor) {
        log.debug("Request to save Ncm : {}", diretor);
        Diretor entity = diretorMapper.toEntity(diretor);
        entity = diretorRepository.save(entity);
        return diretorMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Diretor : {}", id);
        diretorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DiretorDTO> findById(Long id) {
        log.debug("Request to get Diretor : {}", id);
        return diretorRepository.findById(id)
            .map(diretorMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DiretorDTO> findAll(DiretorDTO dto, Pageable pageable) {
        return diretorRepository.findByFilter(dto, pageable);
    }
}
