package com.meli.item.puerto.meli;

import com.meli.item.modelo.entidades.Item;

import java.util.List;

public interface ItemApiMeli {

    Item buscarItemMeli(String id);

    List<Item> buscarItemsMeli(List<String> id);
}
