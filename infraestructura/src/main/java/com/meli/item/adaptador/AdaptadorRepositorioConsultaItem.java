package com.meli.item.adaptador;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdaptadorRepositorioConsultaItem implements RepositorioConsultaItem {

    @Override
    public List<Item> listar() {
        return null;
    }

    @Override
    public Item buscarPorId(String id) {
        return null;
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
