package com.infnet.sistemaOficina.service.impl;

import com.infnet.sistemaOficina.domain.OrdemServico;
import com.infnet.sistemaOficina.domain.Veiculo;
import com.infnet.sistemaOficina.exception.OrdemServicoNotFoundException;
import com.infnet.sistemaOficina.exception.VeiculoException;
import com.infnet.sistemaOficina.repository.OrdemServicoRepository;
import com.infnet.sistemaOficina.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import com.infnet.sistemaOficina.service.OrdemServicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Override
    public OrdemServico criarOrdemServico(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public Optional<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    @Transactional
    public OrdemServico update(Long id, OrdemServico ordemServicoAtualizado) {
        OrdemServico ordemServicoExistente = ordemServicoRepository.findById(id)
                .orElseThrow(() -> new OrdemServicoNotFoundException("Ordem de serviço não encontrada com o ID: " + id));

        BeanUtils.copyProperties(ordemServicoAtualizado, ordemServicoExistente, "id");

        // Salva e retorna a ordem de serviço existente atualizada
        return ordemServicoRepository.save(ordemServicoExistente);
    }

    @Override
    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    @Override
    public OrdemServico getOrdemServicoById(Long id) {
        return ordemServicoRepository.findById(id).orElseThrow(() -> new OrdemServicoNotFoundException("Ordem de servico não encontrada"));
    }


    @Override
    public void adicionarOrdemServico(Long veiculoId, OrdemServico novaOrdemServico) {
        Veiculo veiculo = veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new VeiculoException("Veículo não encontrado com o ID: " + veiculoId));
        novaOrdemServico.setVeiculo(veiculo);
        ordemServicoRepository.save(novaOrdemServico);
    }


}
