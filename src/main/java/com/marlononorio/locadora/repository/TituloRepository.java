package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.service.dto.TituloListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

//    @Query("SELECT new com.marlononorio.locadora.service.dto.TituloListDTO(t.id, t.nome, t.diretor.nome, t.ano, t.categoria, " +
//        "t.classe.nome) FROM Titulo t " +
//        " WHERE (:#{#filtro.nome} is null or (:#{#filtro.nome}) like(concat('%',t.nome,'%')))")
//    Page<TituloListDTO> findByFilter(@Param("filtro") TituloListDTO dto, Pageable pageable);

    Boolean existsTituloByAtoresIdIn(List<Long> ids);
}
