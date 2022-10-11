package com.meli.item.modelo.entidades;

import com.ValidadorArgumento;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
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
        ordenar(listaItemsFavoritos);
        int i = 0;
        if (listaItemsFavoritos.size() > 1 && listaItemsFavoritos.get(i).getPrice() <= this.cupon) {
            this.agregarItemComprado(listaItemsFavoritos.get(i));
            i = 1;
            while ( i < listaItemsFavoritos.size() && (this.cupon - this.precioListaItems) >= listaItemsFavoritos.get(i).getPrice() ) {
                this.agregarItemComprado(listaItemsFavoritos.get(i));
                i++;
            }
        }else if(listaItemsFavoritos.get(i).getPrice() <= this.cupon){
            this.precioListaItems = listaItemsFavoritos.get(i).getPrice();
            this.listaItemsComprados.add(listaItemsFavoritos.get(i));
        }
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
            for (int j = 0; j < items.size() - 1; j++) {
                if (items.get(j).getPrice() > items.get(j + 1).getPrice()) {
                    Item aux = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, aux);
                }
            }
        }
    }
}
