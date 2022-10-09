package com.item.adaptador;

import com.item.modelo.entidades.Item;
import com.item.puerto.repositorio.RepositorioConsultaItem;

import java.util.List;

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
