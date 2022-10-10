package com.meli.configuracion;

import com.meli.comando.manejador.ManejadorCanjearCupon;
import com.meli.item.controlador.ComandoControladorItem;
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
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
