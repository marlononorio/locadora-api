package com.marlononorio.locadora.repository;

import com.marlononorio.locadora.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
