package com.meli.configuracion;

import com.meli.fabrica.FabricaItem;
import com.meli.fabrica.FabricaListaItemsComprados;
import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.consulta.manejador.ManejadorListaItemsTopFavoritos;
import com.meli.item.MapperItem;
import com.meli.item.adaptador.AdaptadorItemApiMeli;
import com.meli.item.adaptador.AdaptadorRepositorioComandoItem;
import com.meli.item.dao.ItemDao;
import com.meli.item.puerto.meli.ItemApiMeli;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import com.meli.item.servicio.ServicioCanjearCupon;
import com.meli.item.servicio.ServicioCrearItemFavoriteado;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
public class BeanServicio {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ServicioCanjearCupon servicioCanjearCupon(RepositorioComandoItem repositorioComandoItem) {
        return new ServicioCanjearCupon(repositorioComandoItem);
    }

    @Bean
    public ServicioCrearItemFavoriteado servicioCrearItemFavoriteado(RepositorioComandoItem repositorioComandoItem, RepositorioConsultaItem repositorioConsultaItem) {
        return new ServicioCrearItemFavoriteado(repositorioComandoItem, repositorioConsultaItem);
    }

    @Bean
    public ManejadorCanjearCupon manejadorCanjearCupon(ServicioCanjearCupon servicioCanjearCupon, ServicioCrearItemFavoriteado servicioCrearItemFavoriteado, ItemApiMeli itemApiMeli, FabricaListaItemsComprados fabricaListaItemsComprados) {
        return new ManejadorCanjearCupon(servicioCanjearCupon, servicioCrearItemFavoriteado, itemApiMeli, fabricaListaItemsComprados);
    }

    @Bean
    public ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos(RepositorioConsultaItem repositorioConsultaItem, FabricaItem fabricaItem) {
        return new ManejadorListaItemsTopFavoritos(repositorioConsultaItem, fabricaItem);
    }

    @Bean
    public AdaptadorItemApiMeli adaptadorItemApiMeli(RestTemplate restTemplate, MapperItem mapperItem) {
        return new AdaptadorItemApiMeli(restTemplate, mapperItem);
    }

    @Bean
    public AdaptadorRepositorioComandoItem repositorioComandoItem(ItemDao itemDao, MapperItem mapperItem) {
        return new AdaptadorRepositorioComandoItem(itemDao, mapperItem);
    }

    @Bean
    public FabricaItem fabricaItem(){
        return new FabricaItem();
    }

    @Bean
    public FabricaListaItemsComprados fabricaListaItemsComprados(){
        return new FabricaListaItemsComprados();
    }
}
