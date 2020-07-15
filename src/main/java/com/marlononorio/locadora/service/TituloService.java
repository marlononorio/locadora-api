package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.repository.TituloRepository;
import com.marlononorio.locadora.service.dto.TituloDTO;
import com.marlononorio.locadora.service.dto.TituloListDTO;
import com.marlononorio.locadora.service.mapper.TituloMapper;
import com.marlononorio.locadora.web.rest.errors.BadRequestAlertException;
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
public class TituloService {

    private final TituloRepository tituloRepository;
    private final TituloMapper tituloMapper;
    private final ItemService itemService;

    public void save(TituloDTO titulo) {
        log.debug("Request to save Titulo: {}", titulo.getId());
        Titulo entity = tituloMapper.toEntity(titulo);
        relacionamento(entity);
    }

    public void relacionamento(Titulo entity) {
        entity.getAtores().forEach(atores -> {
            atores.setId(entity.getId());
            atores.setNome(entity.getNome());
        });

        tituloRepository.saveAndFlush(entity);
    }

    public void delete(Long id) {
        if(!itemService.existsItemByTituloId(id)) {
            throw new BadRequestAlertException("O Titulo selecionado está vinculado a um Item", "Título", "Titulo");
        }

        tituloRepository.deleteById(id);
    }

    public Optional<TituloDTO> findById(Long id) {
        return Optional.empty();
    }

    public Page<TituloListDTO> findByFilter(TituloListDTO dto, Pageable pageable) {
        return tituloRepository.findByFilter(dto, pageable);
    }
}
