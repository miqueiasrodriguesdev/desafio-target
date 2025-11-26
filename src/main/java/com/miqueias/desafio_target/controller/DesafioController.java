package com.miqueias.desafio_target.controller;

import com.miqueias.desafio_target.domain.entity.atividade2.Movimentacao;
import com.miqueias.desafio_target.dto.request.atividade2.MovimentacaoRequest;
import com.miqueias.desafio_target.dto.response.atividade1.ComissaoResponse;
import com.miqueias.desafio_target.service.Atividade1Service;
import com.miqueias.desafio_target.service.Atividade2Service;
import com.miqueias.desafio_target.service.Atividade3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class DesafioController {

    private final Atividade1Service atividade1Service;
    private final Atividade2Service atividade2Service;
    private final Atividade3Service atividade3Service;

    public DesafioController(
            Atividade1Service atividade1Service,
            Atividade2Service atividade2Service,
            Atividade3Service atividade3Service
    ) {
        this.atividade1Service = atividade1Service;
        this.atividade2Service = atividade2Service;
        this.atividade3Service = atividade3Service;
    }

    @GetMapping(value = "/atividade1/buscar-comissoes")
    public ResponseEntity<List<ComissaoResponse>> buscarComissoes() {
        return ResponseEntity.ok(atividade1Service.buscarComissoes());
    }

    @PostMapping(value = "/atividade2/movimentar-estoque")
    public ResponseEntity<Movimentacao> movimentarEstoque(@RequestBody MovimentacaoRequest movimentacaoRequest) {
        return ResponseEntity.ok(
                atividade2Service.movimentarEstoque(
                        movimentacaoRequest.codigoProduto(),
                        movimentacaoRequest.quantidade(),
                        movimentacaoRequest.tipoMovimentacao()
                )
        );
    }

    @GetMapping(value = "/atividade3/valor-corrigido")
    public ResponseEntity<BigDecimal> calcularValorCorrigido(
            @RequestParam BigDecimal valor,
            @RequestParam LocalDate dataVencimento
    ) {
        return ResponseEntity.ok(
                atividade3Service.valorCorrigido(valor, dataVencimento)
        );
    }
}
