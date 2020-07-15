package com.marlononorio.locadora.service.impl;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.repository.TituloRepository;
import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.TituloDTO;
import com.marlononorio.locadora.service.mapper.TituloMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TituloServiceImpl implements BaseService<TituloDTO> {

    private final TituloRepository tituloRepository;
    private final TituloMapper tituloMapper;

    @Override
    public TituloDTO save(TituloDTO titulo) {
        log.debug("Request to save Titulo: {}", titulo.getId());
        Titulo entity = tituloMapper.toEntity(titulo);
        entity = tituloRepository.save(entity);
        return tituloMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<TituloDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<TituloDTO> findByFilter(TituloDTO dto, Pageable pageable) {
        return tituloRepository.findByFilter(dto, pageable);
    }
}
