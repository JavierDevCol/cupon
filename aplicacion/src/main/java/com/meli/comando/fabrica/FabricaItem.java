package com.meli.comando.fabrica;

import com.meli.comando.ItemComando;
import com.meli.item.modelo.entidades.Item;
import org.springframework.stereotype.Component;

@Component
public class FabricaItem {

    public Item crear(ItemComando itemComando) {
        return new Item(
                itemComando.getId(),
                itemComando.getTitle(),
                itemComando.getPrice(),
                itemComando.getSite_id()
        );
    }

    public ItemComando crear(Item item) {
        return new ItemComando(
                item.getId(),
                item.getTitle(),
                item.getPrice(),
                item.getSite_id()
        );
    }
}
