package com.marlononorio.locadora.service.impl;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.repository.AtorRepository;
import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.AtorDTO;
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
public class AtorServiceImpl implements BaseService<AtorDTO> {

    private final Logger log = LoggerFactory.getLogger(AtorServiceImpl.class);

    private final AtorRepository atorRepository;
    private final BaseMapper<Ator, AtorDTO> atorMapper;

    @Override
    public AtorDTO save(AtorDTO ator) {
        log.debug("Request to save Ncm : {}", ator);
        Ator entity = atorMapper.toEntity(ator);
        entity = atorRepository.save(entity);
        return atorMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        atorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AtorDTO> findById(Long id) {
        return atorRepository.findById(id)
            .map(atorMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AtorDTO> findAll(AtorDTO dto, Pageable pageable) {
        return atorRepository.findByFilter(dto, pageable);
    }
}
