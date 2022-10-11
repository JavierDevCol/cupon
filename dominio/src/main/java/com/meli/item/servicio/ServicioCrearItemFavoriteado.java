package com.meli.item.servicio;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;

import java.util.List;
import java.util.Objects;

public class ServicioCrearItemFavoriteado {

    private static final String ITEM_YA_EXISTE = "Este item ya existe.";

    private final RepositorioComandoItem repositorioComandoItem;
    private final RepositorioConsultaItem repositorioConsultaItem;

    public ServicioCrearItemFavoriteado(RepositorioComandoItem repositorioComandoItem, RepositorioConsultaItem repositorioConsultaItem) {
        this.repositorioComandoItem = repositorioComandoItem;
        this.repositorioConsultaItem = repositorioConsultaItem;
    }

    public void ejecutar(List<Item> items) {
        items.forEach(item -> {
                    boolean existe = Objects.isNull(
                            repositorioConsultaItem.buscarPorId(item.getId())
                    );
                    if (existe) {
                        repositorioComandoItem.crear(item);
                    }
                }
        );
    }
}
