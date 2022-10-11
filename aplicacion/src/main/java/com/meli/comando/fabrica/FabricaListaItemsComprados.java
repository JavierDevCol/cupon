package com.meli.comando.fabrica;

import com.meli.comando.ListaItemsCompradosCuponComando;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import org.springframework.stereotype.Component;

@Component
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
