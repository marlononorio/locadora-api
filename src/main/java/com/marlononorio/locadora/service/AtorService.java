package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.repository.AtorRepository;
import com.marlononorio.locadora.service.dto.AtorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import com.marlononorio.locadora.service.mapper.AtorMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AtorService {

    private final Logger log = LoggerFactory.getLogger(AtorService.class);

    private final AtorRepository atorRepository;
    private final AtorMapper atorMapper;

    public AtorDTO save(AtorDTO ator) {
        log.debug("Request to save Ator : {}", ator);
        Ator entity = atorMapper.toEntity(ator);
        entity = atorRepository.save(entity);
        return atorMapper.toDto(entity);
    }

    public void delete(Long id) {
        log.debug("Request to delete Ator : {}", id);
        atorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<AtorDTO> findById(Long id) {
        log.debug("Request to get Ator : {}", id);
        return atorRepository.findById(id)
            .map(atorMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<AtorDTO> findByFilter(AtorDTO dto, Pageable pageable) {
        return atorRepository.findByFilter(dto, pageable);
    }

    public List<ValueLabelDTO> findDescricao(){
        return atorRepository.findDescricao();
    }
}
