package com.miqueias.desafio_target.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Atividade3Service {
    BigDecimal valorCorrigido(BigDecimal valor, LocalDate dataVencimento);
}
