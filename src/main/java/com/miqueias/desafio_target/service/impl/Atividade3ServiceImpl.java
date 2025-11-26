package com.miqueias.desafio_target.service.impl;

import com.miqueias.desafio_target.service.Atividade3Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Atividade3ServiceImpl implements Atividade3Service {

    private static final BigDecimal MULTA_DIARIA = new BigDecimal("0.025");

    @Override
    public BigDecimal valorCorrigido(BigDecimal valor, LocalDate dataVencimento) {

        LocalDate hoje = LocalDate.now();

        if (!hoje.isAfter(dataVencimento)) {
            return valor;
        }

        long diasAtraso = ChronoUnit.DAYS.between(dataVencimento, hoje);

        BigDecimal juros = valor
                .multiply(MULTA_DIARIA)
                .multiply(BigDecimal.valueOf(diasAtraso));

        return valor.add(juros);
    }
}
