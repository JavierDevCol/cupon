package com.meli.item.modelo.entidades;

import com.ValidadorArgumento;
import com.meli.item.modelo.entidades.Item;

import java.util.ArrayList;
import java.util.List;


public class ListaItemsCompradosCupon {

    private static final String PRECIO_MAYOR_CERO = "El precio debe ser mayor a CERO (0).";
    private static final String LISTA_VACIA = "Lista de item favoritos vacia.";

    private List<Item> listaItemsComprados;
    private Double precioListaItems;
    private Double cupon;

    public ListaItemsCompradosCupon(Double cupon) {

        ValidadorArgumento.validarPositivo(cupon, PRECIO_MAYOR_CERO);

        this.listaItemsComprados = new ArrayList<>();
        this.precioListaItems = 0d;
        this.cupon = cupon;
    }

    public void buscarItemsAComprar(List<Item> listaItemsFavoritos) {
        ValidadorArgumento.validarNoVacio(listaItemsFavoritos, LISTA_VACIA);

        if (listaItemsFavoritos.size() == 1) {
            return;
        }
        ordenar(listaItemsFavoritos);
        this.precioListaItems = listaItemsFavoritos.get(0).getPrice();
        this.listaItemsComprados.add(listaItemsFavoritos.get(0));
        int i = 1;
        do {
            this.agregarItemComprado(listaItemsFavoritos.get(i));
            i++;
        }while (
                (this.cupon - this.precioListaItems) >= listaItemsFavoritos.get(i).getPrice()
        );
    }

    private void agregarItemComprado(Item item) {
        this.listaItemsComprados.add(item);
        this.actualizarPrecioLista(item.getPrice());
    }

    private void actualizarPrecioLista(Double precio) {
        this.precioListaItems += precio;
    }

    private static void ordenar(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size() - 1; j++){
                if (items.get(j).getPrice() > items.get(j+1).getPrice()) {
                    Item aux = items.get(j);
                    items.set(j, items.get(j+1));
                    items.set(j+1, aux);
                }
            }
        }
    }
}
