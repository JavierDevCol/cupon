package com.meli.configuracion;

import com.meli.comando.manejador.ManejadorAgregarItem;
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
    public ComandoControladorItem comandoControladorItem(ManejadorAgregarItem manejadorAgregarItem) {
        return new ComandoControladorItem(manejadorAgregarItem);
    }


    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
