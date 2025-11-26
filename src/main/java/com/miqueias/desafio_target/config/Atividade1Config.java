package com.miqueias.desafio_target.config;

import com.miqueias.desafio_target.repository.atividade1.VendaRepository;
import com.miqueias.desafio_target.service.Atividade1Service;
import com.miqueias.desafio_target.service.impl.Atividade1ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Atividade1Config {
    @Bean
    public Atividade1Service atividade1Service(VendaRepository vendaRepository){
        return new Atividade1ServiceImpl(vendaRepository);
    }
}
