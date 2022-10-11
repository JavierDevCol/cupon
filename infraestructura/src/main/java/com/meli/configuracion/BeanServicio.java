package com.meli.configuracion;

import com.meli.comando.fabrica.FabricaListaItemsComprados;
import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.consulta.manejador.ManejadorListaItemsTopFavoritos;
import com.meli.item.MapperItem;
import com.meli.item.adaptador.AdaptadorItemApiMeli;
import com.meli.item.adaptador.AdaptadorRepositorioComandoItem;
import com.meli.item.controlador.ConsultaControladorItem;
import com.meli.item.dao.ItemDao;
import com.meli.item.puerto.meli.ItemApiMeli;
import com.meli.item.puerto.repositorio.RepositorioComandoItem;
import com.meli.item.puerto.repositorio.RepositorioConsultaItem;
import com.meli.item.servicio.ServicioCanjearCupon;
import com.meli.item.servicio.ServicioCrearItemFavoriteado;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
public class BeanServicio {

    //Usuario
//    @Bean
//    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
//        return new ServicioCrearUsuario(repositorioUsuario);
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public ComandoControladorItem comandoControladorItem(ManejadorCanjearCupon manejadorCanjearCupon) {
//        return new ComandoControladorItem(manejadorCanjearCupon);
//    }

    @Bean
    public ServicioCanjearCupon servicioCanjearCupon(){
        return new ServicioCanjearCupon();
    }

    @Bean
    public ServicioCrearItemFavoriteado servicioCrearItemFavoriteado(RepositorioComandoItem repositorioComandoItem, RepositorioConsultaItem repositorioConsultaItem){
        return new ServicioCrearItemFavoriteado(repositorioComandoItem, repositorioConsultaItem);
    }

    @Bean
    public ManejadorCanjearCupon manejadorCanjearCupon(ServicioCanjearCupon servicioCanjearCupon, ServicioCrearItemFavoriteado servicioCrearItemFavoriteado, ItemApiMeli itemApiMeli, FabricaListaItemsComprados fabricaListaItemsComprados){
        return new ManejadorCanjearCupon(servicioCanjearCupon, servicioCrearItemFavoriteado, itemApiMeli, fabricaListaItemsComprados);
    }

    @Bean
    public ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos(){
        return new ManejadorListaItemsTopFavoritos();
    }

    @Bean
    public AdaptadorItemApiMeli adaptadorItemApiMeli (RestTemplate restTemplate, MapperItem mapperItem) {
        return new AdaptadorItemApiMeli(restTemplate, mapperItem);
    }

    @Bean
    public ConsultaControladorItem consultaControladorItem(ManejadorListaItemsTopFavoritos manejadorListaItemsTopFavoritos){
        return new ConsultaControladorItem(manejadorListaItemsTopFavoritos);
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public AdaptadorRepositorioComandoItem repositorioComandoItem(ItemDao itemDao, MapperItem mapperItem){
        return new AdaptadorRepositorioComandoItem(itemDao, mapperItem);

    }
}
