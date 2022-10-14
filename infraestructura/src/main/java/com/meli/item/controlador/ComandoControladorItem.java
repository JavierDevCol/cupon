package com.meli.item.controlador;

import com.excepcion.ExcepcionSinDatos;
import com.meli.comando.ItemComando;
import com.meli.comando.ListaItemsCompradosCuponComando;
import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.item.adaptador.AdaptadorItemApiMeli;
import com.meli.item.modelo.entidades.ListaItemsCompradosCupon;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/hola")
    public String hola(){
        return "HOLA MUNDO";
    }
}
