package com.infnet.sistemaOficina.service.impl;

import com.infnet.sistemaOficina.domain.Servico;
import com.infnet.sistemaOficina.exception.ServicoException;
import com.infnet.sistemaOficina.repository.ServicoRepository;
import com.infnet.sistemaOficina.service.ServicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;
    @Override
    public Servico criarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Override
    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    @Override
    public Optional<Servico> findById(Long id) {
        return servicoRepository.findById(id);
    }

    @Override
    @Transactional
    public Servico atualizarServico(Long id, Servico servicoAtualizado) {
        Servico servicoExistente = servicoRepository.findById(id)
                .orElseThrow(() -> new ServicoException());

        // Copia todas as propriedades não nulas do servicoAtualizado para o servicoExistente
        BeanUtils.copyProperties(servicoAtualizado, servicoExistente, "id");

        // Salva e retorna o serviço existente atualizado
        return servicoRepository.save(servicoExistente);
    }

    @Override
    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }

    @Override
    public Servico getServicoById(Long id) {
        return servicoRepository.findById(id).orElseThrow(() -> new ServicoException());
    }


}
