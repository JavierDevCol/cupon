package com.meli.item.controlador;

import com.meli.comando.manejador.ManejadorAgregarItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/item")
@RequestMapping("/item")
public class ComandoControladorItem {

    private final ManejadorAgregarItem manejadorAgregarItem;

    public ComandoControladorItem(ManejadorAgregarItem manejadorAgregarItem) {
        this.manejadorAgregarItem = manejadorAgregarItem;
    }

}
