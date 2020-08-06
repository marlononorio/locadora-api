package com.marlononorio.locadora.service;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.repository.AtorRepository;
import com.marlononorio.locadora.service.dto.AtorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import com.marlononorio.locadora.service.mapper.AtorMapper;
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
public class AtorService {

    private final AtorRepository atorRepository;
    private final AtorMapper atorMapper;
    private final TituloService tituloService;

    public AtorDTO save(AtorDTO ator) {
        log.debug("Request to save Ator : {}", ator);
        Ator entity = atorMapper.toEntity(ator);
        entity = atorRepository.save(entity);
        return atorMapper.toDto(entity);
    }

    public void delete(Long id) {
        log.debug("Request to delete Ator : {}", id);
//        if(tituloService.existsTituloById(id)) {
//            throw new BadRequestAlertException("NAO FOI POSSIVEL EXCLUIR", "NAO FOI POSSIVEL EXCLUIR", "NAO FOI POSSIVEL EXCLUIR");
//        }
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

    public List<AtorDTO> dropdown() {
        return atorRepository.dropdown();
    }

    public void update(AtorDTO dto) {
        if (atorRepository.existsAtorByIdAndNome(dto.getId(), dto.getNome())){
            throw new BadRequestAlertException("Registro já existe", "Registro já existe", "Registro já existe");
        }
        Ator entity = atorMapper.toEntity(dto);
        atorRepository.save(entity);
    }
}
