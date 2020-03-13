package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<Titulo, Long> {
}
