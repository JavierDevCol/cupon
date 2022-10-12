package com.meli.item.puerto.repositorio;

import com.meli.item.modelo.entidades.Item;

import java.util.List;

public interface RepositorioConsultaItem {

    List<Item> listarTopFavoritos();

    Item buscarPorId(String id);

    Item buscarTitle(String title);

    boolean existePorTitle(String title);

}
