package com.meli.item.servicio;

import com.meli.item.modelo.entidades.Item;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;

import java.util.Objects;

public class ServicioCrearItem {

    private static final String ITEM_YA_EXISTE = "Este item ya existe.";

    private final RepositorioComandoItem repositorioComandoItem;
    private final RepositorioConsultaItem repositorioConsultaItem;

    public ServicioCrearItem(RepositorioComandoItem repositorioComandoItem, RepositorioConsultaItem repositorioConsultaItem) {
        this.repositorioComandoItem = repositorioComandoItem;
        this.repositorioConsultaItem = repositorioConsultaItem;
    }

    public Item ejecutar(Item item) {
        Item existe = repositorioConsultaItem.buscarPorId(item.getId());
        if (Objects.nonNull(existe)) {
            return existe;
        }
        return repositorioComandoItem.crear(item);
    }
}
