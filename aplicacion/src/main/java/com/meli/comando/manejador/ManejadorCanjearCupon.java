package com.meli.comando.manejador;

import com.meli.comando.ItemComando;
import com.meli.comando.fabrica.FabricaItem;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.servicio.ServicioCanjearCupon;
import com.meli.item.servicio.ServicioCrearItemFavoriteado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ManejadorCanjearCupon {

    private final ServicioCanjearCupon servicioCanjearCupon;
    private final ServicioCrearItemFavoriteado servicioCrearItemFavoriteado;
    private final FabricaItem fabricaItem;

    public ListaItemsCompradosCupon ejecutar(List<ItemComando> listaItemsFavoritos, Double cupon) {
        List<Item> listaFavoritos = fabricaItem.crearLista(listaItemsFavoritos);
        servicioCrearItemFavoriteado.ejecutar(listaFavoritos);
        return servicioCanjearCupon.ejecutar(listaFavoritos, cupon);
    }
}
