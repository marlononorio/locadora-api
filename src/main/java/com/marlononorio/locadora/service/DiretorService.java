package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Diretor;
import com.marlononorio.locadora.repository.DiretorRepository;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import com.marlononorio.locadora.service.mapper.DiretorMapper;
import com.marlononorio.locadora.web.rest.errors.BadRequestAlertException;
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
public class DiretorService {

    private final DiretorRepository diretorRepository;
    private final DiretorMapper diretorMapper;

    public DiretorDTO save(DiretorDTO diretor) {
        log.debug("Request to save Ncm : {}", diretor);

        if(diretorRepository.existsDiretorByNome(diretor.getNome())) {
            throw new BadRequestAlertException("Registro já existe", "Registro já existe", "Registro já existe");
        }
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

    @Transactional(readOnly = true)
    public List<ValueLabelDTO> findDescricao(){
        return diretorRepository.findDescricao();
    }

    public List<DiretorDTO> dropdown() {
        return diretorRepository.dropdown();
    }

    public void update(DiretorDTO dto) {
        if (diretorRepository.existsDiretorByNome(dto.getNome())){
            throw new BadRequestAlertException("Registro já existe", "Registro já existe", "Registro já existe");
        }
        Diretor entity = diretorMapper.toEntity(dto);
        diretorRepository.save(entity);
    }
}
