package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.repository.ClasseRepository;
import com.marlononorio.locadora.service.dto.ClasseDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import com.marlononorio.locadora.service.mapper.ClasseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClasseService {

    private final ClasseRepository classeRepository;
    private final ClasseMapper classeMapper;

    public ClasseDTO save(ClasseDTO dto) {
        log.debug("Request to save Classe : {}", dto);
        Classe entity = classeMapper.toEntity(dto);
        entity = classeRepository.save(entity);
        return classeMapper.toDto(entity);
    }

    public void delete(Long id) {
        log.debug("Request to delete Classe : {}", id);
        classeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<ClasseDTO> findById(Long id) {
        log.debug("Request to get Classe : {}", id);
        return classeRepository.findById(id)
            .map(classeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<ClasseDTO> findByFilter(ClasseDTO dto, Pageable pageable) {
        return classeRepository.findByFilter(dto, pageable);
    }

    public List<ValueLabelDTO> findDescricao(){
        return classeRepository.findDescricao();
    }

    public List<ClasseDTO> dropdown() {
        return classeRepository.dropdown();
    }
}
