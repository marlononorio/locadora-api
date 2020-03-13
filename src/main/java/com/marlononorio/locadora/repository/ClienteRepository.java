package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Locacao> {
}
