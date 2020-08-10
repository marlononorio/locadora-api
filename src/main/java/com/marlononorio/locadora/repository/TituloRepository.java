package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Titulo;
import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.ValueLabelDTO(t.id, t.nome) FROM Titulo t")
    List<ValueLabelDTO> findDescricao();
}
