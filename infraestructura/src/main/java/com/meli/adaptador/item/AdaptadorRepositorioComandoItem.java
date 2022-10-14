package com.meli.adaptador.item;

import com.meli.item.MapperItem;
import com.meli.dao.ItemDao;
import com.meli.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class AdaptadorRepositorioComandoItem implements RepositorioComandoItem {

    private final ItemDao itemDao;
    private final MapperItem mapperItem;

    @Override
    public Item crear(Item item) {
        ItemEntity itemEntity = mapperItem.itemToItemEntity(item);
        itemDao.save(itemEntity);
        return mapperItem.intemEntityToItem(itemEntity);
    }

    @Override
    public void actualizar(Item item) {
        ItemEntity entity = itemDao.findById(item.getId()).orElse(null);
        if (Objects.nonNull(entity)) {
            entity.setQuantitySold(
                    entity.getQuantitySold() + 1
            );
            itemDao.save(entity);
        }
    }
}
