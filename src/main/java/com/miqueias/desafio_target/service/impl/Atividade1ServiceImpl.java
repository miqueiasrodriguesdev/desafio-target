package com.miqueias.desafio_target.service.impl;

import com.miqueias.desafio_target.domain.entity.atividade1.Venda;
import com.miqueias.desafio_target.dto.response.atividade1.ComissaoResponse;
import com.miqueias.desafio_target.repository.atividade1.VendaRepository;
import com.miqueias.desafio_target.service.Atividade1Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade1ServiceImpl implements Atividade1Service {
    private final VendaRepository vendaRepository;

    public Atividade1ServiceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Override
    public List<ComissaoResponse> buscarComissoes() {
        List<Venda> vendas = vendaRepository.findAll();


        return vendas.stream()
                .collect(Collectors.groupingBy(Venda::getVendedor))
                .entrySet()
                .stream()
                .map(entry -> {
                    String vendedor = entry.getKey();
                    List<Venda> vendaList = entry.getValue();

                    List<BigDecimal> valores = vendaList.stream()
                            .map(Venda::getValor)
                            .toList();

                    BigDecimal comissaoTotal = vendaList.stream()
                            .map(v -> calcularComissao(v.getValor()))
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
                            .setScale(2, RoundingMode.HALF_UP);

                    return new ComissaoResponse(vendedor, valores, comissaoTotal);
                })
                .toList();

    }

    private BigDecimal calcularComissao(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal("100")) < 0) {
            return BigDecimal.ZERO;
        } else if (valor.compareTo(new BigDecimal("500")) < 0) {
            return valor.multiply(new BigDecimal("0.01"));
        } else {
            return valor.multiply(new BigDecimal("0.05"));
        }
    }

}
