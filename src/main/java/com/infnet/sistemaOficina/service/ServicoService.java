package com.infnet.sistemaOficina.service;

import com.infnet.sistemaOficina.domain.Servico;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface ServicoService {
    Servico criarServico(Servico servico);

    List<Servico> findAll();

    Optional<Servico> findById(Long id);

    Servico atualizarServico(Long id, Servico servicoAtualizado);

    void deleteById(Long id);

    Servico getServicoById(Long id);
}
