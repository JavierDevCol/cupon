package com.meli.item.adaptador;

import com.meli.item.MapperItem;
import com.meli.item.dao.ItemDao;
import com.meli.item.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class AdaptadorRepositorioConsultaItem implements RepositorioConsultaItem {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private MapperItem mapperItem;

    @Override
    public List<Item> listar() {
        return null;
    }

    @Override
    public Item buscarPorId(String id) {
        ItemEntity entity = this.itemDao.findById(id).orElse(null);
        return mapperItem.intemEntityToItem(entity);
    }

    @Override
    public Item buscarTitle(String title) {
        return null;
    }

    @Override
    public boolean existePorTitle(String title) {
        return false;
    }
}
