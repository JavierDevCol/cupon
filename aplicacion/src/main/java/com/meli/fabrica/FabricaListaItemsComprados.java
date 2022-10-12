package com.meli.fabrica;

import com.meli.comando.ListaItemsCompradosCuponComando;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FabricaListaItemsComprados {

    public ListaItemsCompradosCuponComando crear(ListaItemsCompradosCupon listaItemsCompradosCupon){
        ListaItemsCompradosCuponComando res = new ListaItemsCompradosCuponComando(
                listaItemsCompradosCupon.getListaItemsComprados(),
                listaItemsCompradosCupon.getPrecioListaItems(),
                listaItemsCompradosCupon.getCupon()
        );
        return res;
    }

}
