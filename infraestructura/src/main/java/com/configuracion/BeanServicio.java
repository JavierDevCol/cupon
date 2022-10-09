package com.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class BeanServicio {

    //Usuario
//    @Bean
//    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
//        return new ServicioCrearUsuario(repositorioUsuario);
//    }


    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }
}
