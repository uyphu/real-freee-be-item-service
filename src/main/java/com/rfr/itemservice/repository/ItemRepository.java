// ItemRepository.java
package com.rfr.itemservice.repository;

import com.rfr.itemservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}