package com.meli.fabrica;

import com.meli.comando.ItemComando;
import com.meli.item.modelo.entidades.Item;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FabricaItem {

    public Item crear(ItemComando itemComando) {
        return new Item(
                itemComando.getId(),
                itemComando.getTitle(),
                itemComando.getPrice(),
                itemComando.getSite_id(),
                itemComando.getQuantity_sold()

        );
    }

    public ItemComando crear(Item item) {
        return new ItemComando(
                item.getId(),
                item.getTitle(),
                item.getPrice(),
                item.getSite_id(),
                item.getQuantitySold()
        );
    }

   public List<ItemComando> crearLIsta(List<Item> lista){
       List<ItemComando> res = new ArrayList<>();
       lista.forEach(item ->
               res.add(this.crear(item))
       );
       return res;
   }

    public List<Item> crearLista(List<ItemComando> itemList) {
        List<Item> res = new ArrayList<>();
        itemList.forEach(item ->
                res.add(this.crear(item))
        );
        return res;
    }
}
