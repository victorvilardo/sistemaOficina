package com.infnet.sistemaOficina.service;

import com.infnet.sistemaOficina.domain.Carro;
import com.infnet.sistemaOficina.domain.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    Carro criarCarro(Carro carro);

    List<Veiculo> findAll();

    Optional<Veiculo> findById(Long id);

    Veiculo atualizarVeiculo(Long id, Veiculo veiculoAtualizado);

    void deleteById(Long id);

    Veiculo adicionarVeiculo(Veiculo veiculo);
}


