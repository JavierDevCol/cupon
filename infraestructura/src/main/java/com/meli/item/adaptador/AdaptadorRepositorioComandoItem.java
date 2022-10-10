package com.meli.item.adaptador;

import com.meli.item.MapperItem;
import com.meli.item.dao.ItemDao;
import com.meli.item.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AdaptadorRepositorioComandoItem implements RepositorioComandoItem {

    private final ItemDao itemDao;
    private final MapperItem mapperItem;

    @Override
    public Item crear(Item item) {
        ItemEntity itemEntity = mapperItem.itemToItemEntity(item);
        itemDao.save(itemEntity);
        return item;
    }

    @Override
    public Item actualizar(Item item) {
        return null;
    }
}
