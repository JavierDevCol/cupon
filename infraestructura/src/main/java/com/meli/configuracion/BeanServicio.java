package com.meli.configuracion;

import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.item.MapperItem;
import com.meli.item.adaptador.AdaptadorItemApiMeli;
import com.meli.item.controlador.ComandoControladorItem;
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

    //Usuario
//    @Bean
//    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
//        return new ServicioCrearUsuario(repositorioUsuario);
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ComandoControladorItem comandoControladorItem(ManejadorCanjearCupon manejadorCanjearCupon) {
        return new ComandoControladorItem(manejadorCanjearCupon);
    }

    @Bean
    public ServicioCanjearCupon servicioCanjearCupon(){
        return new ServicioCanjearCupon();
    }

    @Bean
    public ServicioCrearItemFavoriteado servicioCrearItemFavoriteado(RepositorioComandoItem repositorioComandoItem, RepositorioConsultaItem repositorioConsultaItem){
        return new ServicioCrearItemFavoriteado(repositorioComandoItem, repositorioConsultaItem);
    }

    @Bean
    public ManejadorCanjearCupon manejadorCanjearCupon(ServicioCanjearCupon servicioCanjearCupon, ServicioCrearItemFavoriteado servicioCrearItemFavoriteado, ItemApiMeli itemApiMeli){
        return new ManejadorCanjearCupon(servicioCanjearCupon, servicioCrearItemFavoriteado, itemApiMeli);
    }

    @Bean
    public AdaptadorItemApiMeli adaptadorItemApiMeli (RestTemplate restTemplate, MapperItem mapperItem) {
        return new AdaptadorItemApiMeli(restTemplate, mapperItem);
    }
    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
