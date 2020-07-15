package com.marlononorio.locadora.service;

import com.marlononorio.locadora.service.dto.ValueLabelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    T save(T ator);

    void delete(Long id);

    Optional<T> findById(Long id);

    Page<T> findByFilter(T dto, Pageable pageable);

    default List<ValueLabelDTO> findDescricao() {
        throw new NotImplementedException();
    }
}
