package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.service.dto.ClasseDTO;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long>, JpaSpecificationExecutor<Classe> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.ClasseDTO(c.id, c.nome, c.valor, c.dtDevolucao) FROM Classe c" +
        " WHERE (:#{#filtro.nome} is null or (:#{#filtro.nome}) like(concat('%',c.nome,'%')))")
    Page<ClasseDTO> findByFilter(@Param("filtro") ClasseDTO dto, Pageable pageable);

    @Query("SELECT new com.marlononorio.locadora.service.dto.ValueLabelDTO(c.id, c.nome) FROM Classe c")
    List<ValueLabelDTO> findDescricao();
}
