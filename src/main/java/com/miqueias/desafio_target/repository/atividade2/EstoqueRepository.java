package com.miqueias.desafio_target.repository.atividade2;

import com.miqueias.desafio_target.domain.entity.atividade2.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("SELECT e FROM Estoque e WHERE e.codigoProduto = :codigoProduto")
    Optional<Estoque> buscarPorCodigoProduto(String codigoProduto);
}
