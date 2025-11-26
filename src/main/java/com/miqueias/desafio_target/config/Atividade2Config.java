package com.miqueias.desafio_target.config;

import com.miqueias.desafio_target.repository.atividade2.EstoqueRepository;
import com.miqueias.desafio_target.repository.atividade2.MovimentacaoRepository;
import com.miqueias.desafio_target.service.Atividade2Service;
import com.miqueias.desafio_target.service.impl.Atividade2ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Atividade2Config {
    @Bean
    public Atividade2Service atividade2Service(MovimentacaoRepository movimentacaoRepository, EstoqueRepository estoqueRepository){
        return new Atividade2ServiceImpl(movimentacaoRepository, estoqueRepository);
    }
}
