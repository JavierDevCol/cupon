package com.item.controlador;

import com.consulta.manejador.ManejadorListaItemsTopFavoritos;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaControladorItem {

    private final ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos;

    public ConsultaControladorItem(ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos) {
        this.manejadorListaItemsTopFavoritos = manejadorListaItemsTopFavoritos;
    }
}
