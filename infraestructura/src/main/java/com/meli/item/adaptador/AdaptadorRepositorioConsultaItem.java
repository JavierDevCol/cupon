package com.meli.item.adaptador;

import com.meli.item.MapperItem;
import com.meli.item.dao.ItemDao;
import com.meli.item.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdaptadorRepositorioConsultaItem implements RepositorioConsultaItem {

    private static final Integer CANTIDAD_TOP = 5;

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private MapperItem mapperItem;

    @Override
    public List<Item> listarTopFavoritos() {
        List<ItemEntity> top = itemDao.findAll(Sort.by(Sort.Direction.DESC, "quantitySold"));
        topCinco(top);
        return mapperItem.intemEntityToItem(top);
    }

    @Override
    public Item buscarPorId(String id) {
        ItemEntity entity = this.itemDao.findById(id).orElse(null);
        return mapperItem.intemEntityToItem(entity);
    }

    private void topCinco(List<ItemEntity> itemEntities) {
        for (int i = itemEntities.size(); i > CANTIDAD_TOP; i--) {
            itemEntities.remove(i - 1);
        }
    }
}
