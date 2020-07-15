package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.service.dto.AtorDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> , JpaSpecificationExecutor<Ator> {

    @Query(value = "SELECT new com.marlononorio.locadora.service.dto.AtorDTO(a.id, a.nome) FROM Ator a" +
        " WHERE (:#{#filtro.nome} is null or (:#{#filtro.nome}) like(concat('%',a.nome,'%')))")
    Page<AtorDTO> findByFilter(@Param("filtro") AtorDTO dto, Pageable pageable);

    @Query("SELECT new com.marlononorio.locadora.service.dto.ValueLabelDTO(a.id, a.nome) FROM Ator a")
    List<ValueLabelDTO> findDescricao();
}
