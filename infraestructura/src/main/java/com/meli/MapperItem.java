package com.meli;


import com.meli.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperItem {

    Item intemEntityToItem(ItemEntity itemEntity);

    ItemEntity itemToItemEntity(Item item);

    List<Item> intemEntityToItem(List<ItemEntity> itemEntity);

    List<ItemEntity> itemToItemEntity(List<Item> item);

}
