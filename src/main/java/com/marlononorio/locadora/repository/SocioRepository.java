package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Socio;
import com.marlononorio.locadora.service.dto.SocioListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

    @Query("SELECT new com.marlononorio.locadora.service.dto.SocioListDTO(s.id, s.nome, s.endereco, s.telefone, s.sexo, s.cpf, s.dtNascimento) FROM Socio s")
    Page<SocioListDTO> findAllSocios(Pageable pageable);
}
