package com.meli.item.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {

    private String id;
    private String title;
    private Double price;
    private String site_id;
}
