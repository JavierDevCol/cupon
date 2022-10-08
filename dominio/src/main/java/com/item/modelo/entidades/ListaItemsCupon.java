package com.item.modelo.entidades;

import com.ValidadorArgumento;
import lombok.Getter;

import java.util.List;

@Getter
public class ListaItemsCupon {

    private static final String PRECIO_MAYOR_CERO = "El precio debe ser mayor a CERO (0)";
    private static final String LISTA_VACIA = "Tiene que comprar al menos un item cone l cupon";

    private List<Item> listaItems;
    private Double precioListaItems;

    public ListaItemsCupon(List<Item> listaItems, Double precioListaItems) {

        ValidadorArgumento.validarNoVacio(listaItems, LISTA_VACIA);
        ValidadorArgumento.validarPositivo(precioListaItems, PRECIO_MAYOR_CERO);

        this.listaItems = listaItems;
        this.precioListaItems = precioListaItems;
    }

    public void agregarItemComprado(Item item) {
        this.listaItems.add(item);
        this.actualizarPrecioLista(item.getPrice());
    }

    private void actualizarPrecioLista(Double precio) {
        this.precioListaItems =+ precio;
    }
}
