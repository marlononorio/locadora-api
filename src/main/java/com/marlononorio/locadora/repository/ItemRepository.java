package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Item;
import com.marlononorio.locadora.service.dto.ItemListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Boolean existsItemByTituloId(Long id);

    @Query("SELECT new com.marlononorio.locadora.service.dto.ItemListDTO(i.id, i.titulo.nome, i.dtAquisicao, i.tipo) " +
        "FROM Item i")
    Page<ItemListDTO> findByFilter(ItemListDTO dto, Pageable pageable);
}
