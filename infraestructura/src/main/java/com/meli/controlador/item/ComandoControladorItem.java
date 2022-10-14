package com.meli.controlador.item;

import com.meli.comando.ListaItemsCompradosCuponComando;
import com.meli.comando.manejador.ManejadorCanjearCupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ComandoControladorItem {

    @Autowired
    private  ManejadorCanjearCupon manejadorCanjearCupon;

    @PostMapping("/coupon")
    @ResponseBody
    public ListaItemsCompradosCuponComando redimirCupon(@RequestBody List<String> listaItemsFavoritos, Double cupon) {
        return manejadorCanjearCupon.ejecutar( listaItemsFavoritos, cupon);
    }
}
