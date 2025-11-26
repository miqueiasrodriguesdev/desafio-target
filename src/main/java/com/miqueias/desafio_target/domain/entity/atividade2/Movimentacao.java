package com.miqueias.desafio_target.domain.entity.atividade2;

import com.miqueias.desafio_target.enumerate.TipoMovimentacao;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    @Column(nullable = false)
    private Integer quantidadeMovimentada;

    @Column(nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(Estoque estoque, Integer quantidadeMovimentada, String tipoMovimentacao) {
        this.estoque = estoque;
        this.quantidadeMovimentada = quantidadeMovimentada;
        setTipoMovimentacao(tipoMovimentacao);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Integer getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(Integer quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = TipoMovimentacao.valueOf(tipoMovimentacao.toUpperCase());
    }
}