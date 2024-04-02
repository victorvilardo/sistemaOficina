package com.infnet.sistemaOficina.service.impl;

import com.infnet.sistemaOficina.domain.Carro;
import com.infnet.sistemaOficina.domain.Veiculo;
import com.infnet.sistemaOficina.exception.VeiculoException;
import com.infnet.sistemaOficina.repository.VeiculoRepository;
import com.infnet.sistemaOficina.service.VeiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Override
    public Carro criarCarro(Carro carro) {
        return veiculoRepository.save(carro);
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    @Override
    @Transactional
    public Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado) {
        Veiculo veiculoExistente = veiculoRepository.findById(id)
                .orElseThrow(() -> new VeiculoException("Veículo não encontrado com o ID: " + id));

        BeanUtils.copyProperties(veiculoAtualizado, veiculoExistente, "id");
        return veiculoRepository.save(veiculoExistente);
    }

    @Override
    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }

    @Override
    public Veiculo adicionarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
    public Veiculo getMecanicoById(Long id) {
        return veiculoRepository.findById(id).orElseThrow(() -> new VeiculoException("Mecânico não encontrado"));
    }

}
