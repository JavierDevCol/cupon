package com.meli.item.controlador;

import com.meli.comando.ItemComando;
import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.item.adaptador.AdaptadorItemApiMeli;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/item")
@RequestMapping("/item")
@RequiredArgsConstructor
public class ComandoControladorItem {

    private final ManejadorCanjearCupon manejadorCanjearCupon;

    @PostMapping("/coupon")
    public ListaItemsCompradosCupon redimirCupon(List<String> listaItemsFavoritos, Double cupon) {

        return manejadorCanjearCupon.ejecutar( listaItemsFavoritos, cupon);
    }

}
