package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Classe;
import com.marlononorio.locadora.service.dto.ClasseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClasseRepository extends JpaRepository<Classe, Long>, JpaSpecificationExecutor<Classe> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.ClasseDTO(c.id, c.nome, c.valor, c.dtDevolucao) FROM Classe c" +
        " WHERE (:#{#filtro.nome} IS NULL OR LOWER(c.nome) LIKE LOWER(CONCAT(CONCAT('%', :#{#filtro.nome}), '%')))" +
        " AND (:#{#filtro.valor} IS NULL OR c.valor = :#{#filtro.valor})" +
        " AND (:#{#filtro.dtDevolucao} IS NULL OR TRUNC(c.dtDevolucao) = TO_DATE(:#{#filtro.dtDevolucao}, 'DD/MM/YYYY'))")
    Page<ClasseDTO> findByFilter(@Param("filtro") ClasseDTO dto, Pageable pageable);
}
