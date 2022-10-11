package com.meli.comando;

import com.meli.item.modelo.entidades.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListaItemsCompradosCuponComando {

    private List<Item> listaItemsComprados;
    private Double precioListaItems;
    private Double cupon;

}
