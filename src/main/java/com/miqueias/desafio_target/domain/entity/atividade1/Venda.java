package com.miqueias.desafio_target.domain.entity.atividade1;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vendedor;

    @Column(nullable = false)
    private BigDecimal valor;

    public Venda() {}

    public Venda(String vendedor, BigDecimal valor) {
        this.vendedor = vendedor;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
