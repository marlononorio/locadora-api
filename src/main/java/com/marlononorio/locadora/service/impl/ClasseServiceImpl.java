package com.marlononorio.locadora.service.impl;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.repository.ClasseRepository;
import com.marlononorio.locadora.service.BaseService;
import com.marlononorio.locadora.service.dto.ClasseDTO;
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
public class ClasseServiceImpl implements BaseService<ClasseDTO> {

    private final Logger log = LoggerFactory.getLogger(AtorServiceImpl.class);

    private final ClasseRepository classeRepository;
    private final BaseMapper<Classe, ClasseDTO> classeMapper;

    @Override
    public ClasseDTO save(ClasseDTO dto) {
        log.debug("Request to save Classe : {}", dto);
        Classe entity = classeMapper.toEntity(dto);
        entity = classeRepository.save(entity);
        return classeMapper.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Classe : {}", id);
        classeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClasseDTO> findById(Long id) {
        log.debug("Request to get Classe : {}", id);
        return classeRepository.findById(id)
            .map(classeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClasseDTO> findAll(ClasseDTO dto, Pageable pageable) {
        return classeRepository.findByFilter(dto, pageable);
    }
}
