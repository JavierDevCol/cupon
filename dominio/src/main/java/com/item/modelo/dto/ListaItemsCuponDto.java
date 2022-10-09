package com.item.modelo.dto;

import com.ValidadorArgumento;
import com.item.modelo.entidades.Item;
import lombok.Getter;

import java.util.List;

@Getter
public class ListaItemsCuponDto {

    private static final String PRECIO_MAYOR_CERO = "El precio debe ser mayor a CERO (0)";
    private static final String LISTA_VACIA = "Tiene que comprar al menos un item cone l cupon";

    private List<Item> listaItemsComprados;
    private Double precioListaItems;

    public ListaItemsCuponDto(List<Item> listaItems, Double precioListaItems) {

        ValidadorArgumento.validarNoVacio(listaItems, LISTA_VACIA);
        ValidadorArgumento.validarPositivo(precioListaItems, PRECIO_MAYOR_CERO);

        this.listaItemsComprados = listaItems;
        this.precioListaItems = precioListaItems;
    }

    public void buscarItemAComprar(List<Item> listaItemsFavoritos, Double valorCupon) {
        ordenar(listaItemsFavoritos);
        this.precioListaItems = listaItemsFavoritos.get(0).getPrice();
        int i = 1;
        do {
            this.agregarItemComprado(listaItemsFavoritos.get(i));
            i++;
        }while (
                (valorCupon - this.precioListaItems) >= listaItemsFavoritos.get(i).getPrice()
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
