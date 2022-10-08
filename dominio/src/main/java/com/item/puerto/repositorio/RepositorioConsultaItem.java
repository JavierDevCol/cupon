package com.item.puerto.repositorio;

import com.item.modelo.entidades.Item;

import java.util.List;

public interface RepositorioConsultaItem {

    List<Item> listar();

    Item buscarPorId(String id);

    Item buscarTitle(String title);

    boolean existePorTitle(String title);

}
