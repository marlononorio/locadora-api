package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Diretor;
import com.marlononorio.locadora.service.dto.DiretorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiretorRepository extends JpaRepository<Diretor, Long>, JpaSpecificationExecutor<Diretor> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.DiretorDTO(d.id, d.nome) FROM Diretor d " +
        " WHERE (:#{#filtro.nome} is null or (:#{#filtro.nome}) like(concat('%',d.nome,'%')))")
    Page<DiretorDTO> findByFilter(@Param("filtro") DiretorDTO dto, Pageable pageable);

    @Query("SELECT new com.marlononorio.locadora.service.dto.ValueLabelDTO(d.id, d.nome) FROM Diretor d")
    List<ValueLabelDTO> findDescricao();

    @Query("SELECT new com.marlononorio.locadora.service.dto.DiretorDTO(d.id, d.nome) FROM Diretor d")
    List<DiretorDTO> dropdown();
}
