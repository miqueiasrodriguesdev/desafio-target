package com.miqueias.desafio_target.service.impl;

import com.miqueias.desafio_target.domain.entity.atividade2.Estoque;
import com.miqueias.desafio_target.domain.entity.atividade2.Movimentacao;
import com.miqueias.desafio_target.repository.atividade2.EstoqueRepository;
import com.miqueias.desafio_target.repository.atividade2.MovimentacaoRepository;
import com.miqueias.desafio_target.service.Atividade2Service;

public class Atividade2ServiceImpl implements Atividade2Service {
    private final MovimentacaoRepository movimentacaoRepository;
    private final EstoqueRepository estoqueRepository;

    public Atividade2ServiceImpl(MovimentacaoRepository movimentacaoRepository, EstoqueRepository estoqueRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public Movimentacao movimentarEstoque(String codigoProduto, Integer quantidade, String tipoMovimentacao) {

        Estoque estoque = estoqueRepository.buscarPorCodigoProduto(codigoProduto)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado!"));

        Integer estoqueAtual = estoque.getEstoque();

        if (tipoMovimentacao.equalsIgnoreCase("SAIDA")) {

            if (estoqueAtual - quantidade < 0) {
                throw new RuntimeException("A quantidade informada ultrapassa o estoque disponível!");
            }

            estoque.setEstoque(estoqueAtual - quantidade);

        } else if (tipoMovimentacao.equalsIgnoreCase("ENTRADA")) {

            estoque.setEstoque(estoqueAtual + quantidade);

        } else {
            throw new RuntimeException("Tipo de movimentação inválido! Use ENTRADA ou SAIDA.");
        }

        estoqueRepository.save(estoque);

        Movimentacao movimentacao = new Movimentacao(
                estoque,
                quantidade,
                tipoMovimentacao
        );

        movimentacaoRepository.save(movimentacao);

        return movimentacao;
    }

}
