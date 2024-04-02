package com.infnet.sistemaOficina.service.impl;

import com.infnet.sistemaOficina.domain.Mecanico;
import com.infnet.sistemaOficina.exception.MecanicoException;
import com.infnet.sistemaOficina.exception.ServicoException;
import com.infnet.sistemaOficina.repository.MecanicoRepository;
import com.infnet.sistemaOficina.service.MecanicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;


    @Override
    public Mecanico salvaMecanico(Mecanico mecanico) {
        return mecanicoRepository.save(mecanico);
    }


    @Override
    public List<Mecanico> findAll() {
        return mecanicoRepository.findAll();
    }

    @Override
    public Optional<Mecanico> findById(Long id) {
        return mecanicoRepository.findById(id);
    }

    @Override
    @Transactional
    public Mecanico update(Long id, Mecanico mecanicoAtualizado) {
        Mecanico mecanicoExistente = mecanicoRepository.findById(id)
                .orElseThrow(() -> new MecanicoException("Mecânico não encontrado com o ID: " + id));

        Optional.ofNullable(mecanicoAtualizado.getNome())
                .ifPresent(mecanicoExistente::setNome);

        Optional.ofNullable(mecanicoAtualizado.getEspecialidade())
                .ifPresent(mecanicoExistente::setEspecialidade);

        // Salva e retorna o mecânicoExistente atualizado
        return mecanicoRepository.save(mecanicoExistente);
    }

    @Override
    public void deleteById(Long id) {
        mecanicoRepository.deleteById(id);
    }

    @Override
    public Mecanico getMecanicoById(Long id) {
        return mecanicoRepository.findById(id).orElseThrow(() -> new MecanicoException("Mecânico não encontrado"));
    }


}
