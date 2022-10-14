package com.meli.adaptador.item;

import com.excepcion.ExcepcionObjectoNoEncontrado;
import com.excepcion.ExcepcionTecnica;
import com.meli.MapperItem;
import com.meli.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.meli.ItemApiMeli;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class AdaptadorItemApiMeli implements ItemApiMeli {

    private static final String URL = "https://api.mercadolibre.com/";
    private static final String BUSCAR_ITEM = "/items/";
    private static final String ITEM_NO_ENCONTRADO = "No se encontro el item: ";
    private static final String ID_ITEM_INCOMPLETO = "El id no es valido: ";


    private final RestTemplate restTemplate;


    private final MapperItem mapperItem;

    @Override
    public Item buscarItemMeli(String id) {
        id = this.validarFormatoSitie(id);
        ResponseEntity<ItemEntity> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(
                    URL + BUSCAR_ITEM + id,
                    ItemEntity.class
            );
        } catch (Exception e) {
            throw new ExcepcionObjectoNoEncontrado(ITEM_NO_ENCONTRADO.concat(id));
        }
        ItemEntity itemEntity = responseEntity.getBody();
        itemEntity.aumentarQuantitySold();
        return mapperItem.intemEntityToItem(itemEntity);
    }

    @Override
    public List<Item> buscarItemsMeli(List<String> ids) {
        List<Item> items = new ArrayList<>();
        ids.forEach(id ->
                items.add(
                        this.buscarItemMeli(id)
                )
        );
        return items;
    }

    private String validarFormatoSitie(String id) {
        if (id.length() <= 3 && !id.substring(0, 3).matches("[A-Za-z]*")) {
            throw new ExcepcionTecnica(ID_ITEM_INCOMPLETO.concat(id));
        }
        String sitie = id.substring(0, 3);
        return id.replace(sitie, sitie.toUpperCase());
    }

}
