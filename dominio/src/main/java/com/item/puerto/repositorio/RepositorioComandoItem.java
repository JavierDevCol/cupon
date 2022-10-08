package com.item.puerto.repositorio;

import com.item.modelo.entidades.Item;

public interface RepositorioComandoItem {

    Item crear(Item item);

    Item actualizar(Item item);

}
