package com.infnet.sistemaOficina.controller;

import com.infnet.sistemaOficina.domain.OrdemServico;
import com.infnet.sistemaOficina.domain.Servico;
import com.infnet.sistemaOficina.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> criarOrdemServico(@RequestBody OrdemServico ordemServico) {
        OrdemServico novaOrdemServico = ordemServicoService.criarOrdemServico(ordemServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrdemServico);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<OrdemServico>> retornaOrdemServico() {
        List<OrdemServico> ordemServicos = ordemServicoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ordemServicos);
    }


}
