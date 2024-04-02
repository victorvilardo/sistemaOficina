package com.infnet.sistemaOficina.repository;

import com.infnet.sistemaOficina.domain.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}