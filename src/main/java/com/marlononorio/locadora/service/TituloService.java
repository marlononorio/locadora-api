package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.repository.TituloRepository;
import com.marlononorio.locadora.service.dto.TituloDTO;
import com.marlononorio.locadora.service.dto.TituloListDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import com.marlononorio.locadora.service.mapper.TituloMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TituloService {

    private final TituloMapper tituloMapper;
    private final TituloRepository tituloRepository;

    public void save(TituloDTO titulo) {
        log.debug("Request to save Titulo: {}", titulo.getId());
        Titulo entity = tituloMapper.toEntity(titulo);
        tituloRepository.saveAndFlush(entity);
    }

    public Page<TituloDTO> findByFilter(TituloListDTO dto, Pageable pageable) {
        return tituloRepository.findAll(pageable).map(tituloMapper::toDto);
    }

    public void delete(Long id) {
        tituloRepository.deleteById(id);
    }

    public List<ValueLabelDTO> findDescricao() {
        return tituloRepository.findDescricao();
    }

    public Titulo findById(Long titulo) {
        return tituloRepository.findById(titulo).get();
    }
}
