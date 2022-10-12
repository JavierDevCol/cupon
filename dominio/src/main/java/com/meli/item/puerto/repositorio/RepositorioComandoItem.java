package com.meli.item.puerto.repositorio;

import com.meli.item.modelo.entidades.Item;

public interface RepositorioComandoItem {

    Item crear(Item item);

    void actualizar(Item item);

}
