package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Socio;
import com.marlononorio.locadora.service.dto.SocioDTO;
import com.marlononorio.locadora.service.dto.SocioListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.SocioListDTO(s.id, s.nome, s.endereco, s.telefone, s.sexo, s.cpf, s.dtNascimento) FROM Socio s")
    Page<SocioListDTO> findAllSocios(Pageable pageable);

    @Query("UPDATE Socio s SET s.nome = :#{#dto.nome}, s.endereco = :#{#dto.endereco}, " +
        "s.telefone = :#{#dto.telefone}, s.sexo = :#{#dto.sexo}, s.cpf = :#{#dto.cpf}, " +
        "s.dtNascimento = :#{#dto.dtNascimento} " +
        "WHERE s.id = :#{#dto.id}")
    @Modifying
    void update(@Param("dto") SocioDTO dto);
}
