package com.meli.item;

import com.meli.item.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperItem {

    Item intemEntityToItem(ItemEntity itemEntity);

    ItemEntity itemToItemEntity(Item item);

}
