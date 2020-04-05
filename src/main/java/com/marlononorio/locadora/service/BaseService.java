package com.marlononorio.locadora.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseService<T> {

    T save(T ator);

    void delete(Long id);

    Optional<T> findById(Long id);

    Page<T> findAll(T dto, Pageable pageable);
}
