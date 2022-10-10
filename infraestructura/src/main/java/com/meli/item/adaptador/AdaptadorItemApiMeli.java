package com.meli.item.adaptador;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.meli.ItemApiMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class AdaptadorItemApiMeli implements ItemApiMeli {

    private static final String URL = "https://api.mercadolibre.com/";
//    private static final String ITEMS = "/sites";
//    private static final String LISTA_ITEMS_CATEGORIA = "/sites/$SITE_ID/search?category=$CATEGORY_ID";
    private static final String BUSCAR_ITEM = "/items/";


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Item buscarItem(String id) {

        restTemplate.getForEntity(
                URL + BUSCAR_ITEM + id,
                Object.class
        );
        return null;
    }

    @Override
    public List<Item> buscarItems(List<String> id) {
        return null;
    }

}
