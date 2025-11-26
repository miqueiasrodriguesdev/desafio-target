package com.miqueias.desafio_target.repository.atividade2;

import com.miqueias.desafio_target.domain.entity.atividade2.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
