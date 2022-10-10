package com.meli.item.controlador;


import com.meli.consulta.manejador.ManejadorListaItemsTopFavoritos;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "value")
public class ConsultaControladorItem {

    private final ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos;

    public ConsultaControladorItem(ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos) {
        this.manejadorListaItemsTopFavoritos = manejadorListaItemsTopFavoritos;
    }
}
