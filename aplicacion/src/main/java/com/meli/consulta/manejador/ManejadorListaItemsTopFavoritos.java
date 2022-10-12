package com.meli.consulta.manejador;

import com.meli.comando.ItemComando;
import com.meli.fabrica.FabricaItem;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ManejadorListaItemsTopFavoritos {

    private final RepositorioConsultaItem repositorioConsultaItem;
    private final FabricaItem fabricaItem;

    public List<ItemComando> ejecutar() {
        return fabricaItem.crearLIsta(
                repositorioConsultaItem.listarTopFavoritos()
        );
    }
}
