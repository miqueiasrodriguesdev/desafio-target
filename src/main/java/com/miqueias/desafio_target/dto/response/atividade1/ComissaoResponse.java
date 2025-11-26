package com.miqueias.desafio_target.dto.response.atividade1;

import java.math.BigDecimal;
import java.util.List;

public record ComissaoResponse(String vendedor, List<BigDecimal> vendas, BigDecimal comissao) {
}
