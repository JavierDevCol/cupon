package com.item.controlador;

import com.comando.manejador.ManejadorAgregarItem;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/item")
public class ComandoControladorItem {

    private final ManejadorAgregarItem manejadorAgregarItem;

    public ComandoControladorItem(ManejadorAgregarItem manejadorAgregarItem) {
        this.manejadorAgregarItem = manejadorAgregarItem;
    }

}
