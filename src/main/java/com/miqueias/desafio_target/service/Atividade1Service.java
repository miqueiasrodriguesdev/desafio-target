package com.miqueias.desafio_target.service;

import com.miqueias.desafio_target.dto.response.atividade1.ComissaoResponse;
import java.util.List;

public interface Atividade1Service {
    List<ComissaoResponse> buscarComissoes();
}
