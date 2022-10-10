package com.meli.item.puerto.meli;

import com.meli.item.modelo.entidades.Item;

import java.util.List;

public interface ItemApiMeli {

    Item buscarItem(String id);

    List<Item> buscarItems(List<String> id);
}
