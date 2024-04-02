package com.infnet.sistemaOficina.service;

import com.infnet.sistemaOficina.domain.OrdemServico;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoService {
    OrdemServico criarOrdemServico(OrdemServico ordemServico);

    List<OrdemServico> findAll();

    Optional<OrdemServico> findById(Long id);

    OrdemServico update(Long id, OrdemServico ordemServicoAtualizado);

    void deleteById(Long id);

    OrdemServico getOrdemServicoById(Long id);

    void adicionarOrdemServico(Long veiculoId, OrdemServico novaOrdemServico);
}
