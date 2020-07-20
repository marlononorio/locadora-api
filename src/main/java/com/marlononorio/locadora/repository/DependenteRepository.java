package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Dependente;
import com.marlononorio.locadora.service.dto.DependenteListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.DependenteListDTO(d.id, d.nome, d.dtNascimento, d.sexo, d.status) FROM Dependente d WHERE d.socio.id = :id")
    List<DependenteListDTO> findAllBySocioId(@Param("id") Long id);

    Boolean existsBySocioId(Long id);
}
