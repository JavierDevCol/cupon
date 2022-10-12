package com.meli.item.servicio;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;

import java.util.List;

public class ServicioCanjearCupon {

    private final RepositorioComandoItem repositorioComandoItem;

    public ServicioCanjearCupon(RepositorioComandoItem repositorioComandoItem) {
        this.repositorioComandoItem = repositorioComandoItem;
    }


    public ListaItemsCompradosCupon ejecutar(List<Item> listaItemsFavoritos, Double montoCupon) {
        ListaItemsCompradosCupon itemsComprados = new ListaItemsCompradosCupon(montoCupon);
        itemsComprados.buscarItemsAComprar(listaItemsFavoritos);
        itemsComprados.getListaItemsComprados().forEach(
                repositorioComandoItem::actualizar
        );
        return itemsComprados;
    }
}
