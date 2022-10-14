package com.meli.dto;

import com.meli.comando.ItemComando;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaItemsTopFavoritosDto {

    private List<ItemComando> itemComandos;

}
