package com.meli.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemComando {

    private String id;
    private String title;
    private Double price;
    private String site_id;
    private Long quantity_sold;

}