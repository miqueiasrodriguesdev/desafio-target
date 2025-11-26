package com.miqueias.desafio_target.config.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miqueias.desafio_target.domain.entity.atividade2.Estoque;
import com.miqueias.desafio_target.repository.atividade2.EstoqueRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class LoadEstoque {
    private final EstoqueRepository estoqueRepository;

    public LoadEstoque(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Bean
    CommandLineRunner initEstoque() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Estoque>> typeReference = new TypeReference<>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/estoque.json");

            try {
                List<Estoque> estoques = mapper.readValue(inputStream, typeReference);
                estoqueRepository.saveAll(estoques);
                System.out.println("Dados carregados do JSON com sucesso! " + estoques.size() + " estoque inseridos.");
            } catch (Exception e) {
                System.out.println("Erro ao carregar dados do JSON: " + e.getMessage());
            }
        };
    }
}