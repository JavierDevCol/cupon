package com.meli.item.controlador;


import com.meli.consulta.manejador.ManejadorListaItemsTopFavoritos;
import com.meli.item.dto.ListaItemsTopFavoritosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaControladorItem {

    @Autowired
    private  ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos;

   @GetMapping("/cupon/stats")
    public ListaItemsTopFavoritosDto listarTop(){
       return new ListaItemsTopFavoritosDto(manejadorListaItemsTopFavoritos.ejecutar());
   }
}
