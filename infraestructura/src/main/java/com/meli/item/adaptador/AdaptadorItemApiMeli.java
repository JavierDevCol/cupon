package com.meli.item.adaptador;

import com.excepcion.ExcepcionTecnica;
import com.meli.item.MapperItem;
import com.meli.item.entity.ItemEntity;
import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.meli.ItemApiMeli;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RequiredArgsConstructor
public class AdaptadorItemApiMeli implements ItemApiMeli {

    private static final String URL = "https://api.mercadolibre.com/";
    private static final String BUSCAR_ITEM = "/items/";
    private static final String ITEM_NO_ENCONTRADO = "No se encontro el item: ";
    private static final String ID_ITEM_INCOMPLETO = "El id no es valido: ";


    private final RestTemplate restTemplate;
    private final MapperItem mapperItem;

    @Override
    public Item buscarItem(String id) {
        this.validarFormatoSitie(id);
        ResponseEntity<ItemEntity> entity = restTemplate.getForEntity(
                URL + BUSCAR_ITEM + id,
                ItemEntity.class
        );
        if (Objects.isNull(entity.getBody())) {
            throw new ExcepcionTecnica(ITEM_NO_ENCONTRADO.concat(id));
        }
        return mapperItem.intemEntityToItem(entity.getBody());
    }

    @Override
    public List<Item> buscarItems(List<String> ids) {
        List<Item> items = new ArrayList<>();
        ids.forEach(id ->
                items.add(
                        this.buscarItem(id)
                )
        );
        return items;
    }

    private void validarFormatoSitie(String id) {
        if (id.length() <= 3 && !id.substring(0, 3).matches("[A-Za-z]*")) {
            throw new ExcepcionTecnica(ID_ITEM_INCOMPLETO.concat(id));
        }
        String sitie = id.substring(0, 3);
        id.replace(sitie, sitie.toUpperCase());
    }

}
