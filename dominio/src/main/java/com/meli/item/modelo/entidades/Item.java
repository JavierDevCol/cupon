package com.meli.item.modelo.entidades;

import com.ValidadorArgumento;
import lombok.Getter;

@Getter
public class Item {

    private static final String PRECIO_MAYOR_CERO = "El precio debe ser mayor a CERO (0)";

    private String id;
    private String title;
    private Double price;
    private String site_id;

    public Item(String id, String title, Double price, String site_id) {

        ValidadorArgumento.validarPositivo(price, PRECIO_MAYOR_CERO);
        priceDosDecimales(price);

        this.id = id;
        this.title = title;
        this.site_id = site_id;
    }

    private void priceDosDecimales(Double price) {
        this.price = (double) Math.round(price * 100d) / 100d;
    }

}
