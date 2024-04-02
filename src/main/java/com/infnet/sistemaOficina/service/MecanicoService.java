package com.infnet.sistemaOficina.service;

import com.infnet.sistemaOficina.domain.Mecanico;

import java.util.List;
import java.util.Optional;

public interface MecanicoService {

    Mecanico salvaMecanico(Mecanico mecanico);

    List<Mecanico> findAll();

    Optional<Mecanico> findById(Long id);
    Mecanico update(Long id, Mecanico mecanicoAtualizado);

    void deleteById(Long id);

    Mecanico getMecanicoById(Long id);
}
