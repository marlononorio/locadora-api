package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Boolean existsItemByTituloId(Long id);
}
