package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Ator;
import com.marlononorio.locadora.service.dto.AtorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AtorRepository extends JpaRepository<Ator, Long> , JpaSpecificationExecutor<Ator> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.AtorDTO(a.id, a.nome) FROM Ator a" +
        " WHERE (:#{#filtro.nome} IS NULL OR LOWER(a.nome) LIKE LOWER(CONCAT(CONCAT('%', :#{#filtro.nome}), '%')))")
    Page<AtorDTO> findByFilter(@Param("filtro") AtorDTO dto, Pageable pageable);
}
