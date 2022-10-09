package com.item.puerto.meli;

import com.item.modelo.entidades.Item;

import java.util.List;

public interface ItemApiMeli {

    Item buscarItem(String id);

    List<Item> buscarItems(String id);
}
