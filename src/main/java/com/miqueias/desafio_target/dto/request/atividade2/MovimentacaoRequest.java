package com.miqueias.desafio_target.dto.request.atividade2;

public record MovimentacaoRequest(
        String codigoProduto,
        Integer quantidade,
        String tipoMovimentacao
) {}
