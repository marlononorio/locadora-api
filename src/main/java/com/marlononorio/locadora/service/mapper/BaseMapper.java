package com.marlononorio.locadora.service.mapper;

public interface BaseMapper<T, U> {
    T toEntity(U dto);

    U toDto(T entity);
}
