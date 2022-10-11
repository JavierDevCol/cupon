package com.meli.comando.manejador;

import com.meli.comando.ListaItemsCompradosCuponComando;
import com.meli.comando.fabrica.FabricaListaItemsComprados;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import com.meli.item.puerto.meli.ItemApiMeli;
import com.meli.item.servicio.ServicioCanjearCupon;
import com.meli.item.servicio.ServicioCrearItemFavoriteado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
public class ManejadorCanjearCupon {

    private final ServicioCanjearCupon servicioCanjearCupon;
    private final ServicioCrearItemFavoriteado servicioCrearItemFavoriteado;
    private final ItemApiMeli itemApiMeli;
    private final FabricaListaItemsComprados fabricaListaItemsComprados;

    public ListaItemsCompradosCuponComando ejecutar(List<String> listaItemsFavoritos, Double cupon) {
        List<Item> listaFavoritos = itemApiMeli.buscarItems(listaItemsFavoritos);
        servicioCrearItemFavoriteado.ejecutar(listaFavoritos);
        return fabricaListaItemsComprados.crear(servicioCanjearCupon.ejecutar(listaFavoritos, cupon));
    }
}
