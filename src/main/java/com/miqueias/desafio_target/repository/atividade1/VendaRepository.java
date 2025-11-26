package com.miqueias.desafio_target.repository.atividade1;

import com.miqueias.desafio_target.domain.entity.atividade1.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
