package com.meli.item.servicio;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;

import java.util.List;

public class ServicioCanjearCupon {

    public ListaItemsCompradosCupon ejecutar(List<Item> listaItemsFavoritos, Double montoCupon) {
        ListaItemsCompradosCupon itemsComprados = new ListaItemsCompradosCupon(montoCupon);
        itemsComprados.buscarItemsAComprar(listaItemsFavoritos);
        return itemsComprados;
    }
}
