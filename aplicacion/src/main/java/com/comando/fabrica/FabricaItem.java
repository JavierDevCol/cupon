package com.comando.fabrica;

import com.comando.ItemComando;
import com.item.modelo.entidades.Item;
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
