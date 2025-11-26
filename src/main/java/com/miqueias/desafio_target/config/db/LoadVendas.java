package com.miqueias.desafio_target.config.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miqueias.desafio_target.domain.entity.atividade1.Venda;
import com.miqueias.desafio_target.repository.atividade1.VendaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class LoadVendas {
    private final VendaRepository vendaRepository;

    public LoadVendas(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Bean
    CommandLineRunner initVendas() {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Venda>> typeReference = new TypeReference<>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/vendas.json");

            try {
                List<Venda> vendas = mapper.readValue(inputStream, typeReference);
                vendaRepository.saveAll(vendas);
                System.out.println("Dados carregados do JSON com sucesso! " + vendas.size() + " vendas inseridas.");
            } catch (Exception e) {
                System.out.println("Erro ao carregar dados do JSON: " + e.getMessage());
            }
        };
    }
}