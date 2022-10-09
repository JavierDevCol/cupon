package com.item.dao;

import com.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
