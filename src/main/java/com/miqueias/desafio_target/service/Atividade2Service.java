package com.miqueias.desafio_target.service;

import com.miqueias.desafio_target.domain.entity.atividade2.Movimentacao;

public interface Atividade2Service {
    Movimentacao movimentarEstoque(String codigoProduto, Integer quantidade, String tipoMovimentacao);
}
