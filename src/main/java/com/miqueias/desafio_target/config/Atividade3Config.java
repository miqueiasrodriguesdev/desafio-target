package com.miqueias.desafio_target.config;

import com.miqueias.desafio_target.service.Atividade3Service;
import com.miqueias.desafio_target.service.impl.Atividade3ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Atividade3Config {
    @Bean
    public Atividade3Service atividade3Service(){
        return new Atividade3ServiceImpl();
    }
}
