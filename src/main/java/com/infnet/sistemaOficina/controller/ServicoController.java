package com.infnet.sistemaOficina.controller;

import com.infnet.sistemaOficina.domain.Servico;
import com.infnet.sistemaOficina.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.criarServico(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }
    

    @GetMapping("/listar")
    public ResponseEntity<List<Servico>> retornaTodosServicos() {
        List<Servico> servicos = servicoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Servico>> retornaServicoPorId(@PathVariable("id") Long id) {
        try {
            Optional<Servico> servico = servicoService.findById(id);
            if (servico.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(servico);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/atualiza/{id}")
    public ResponseEntity<Servico> atualizaservico(@PathVariable("id") Long id, @RequestBody Servico servico) {
        Servico novoservico = servicoService.atualizarServico(id, servico);
        return ResponseEntity.status(HttpStatus.OK).body(novoservico);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deletaServico(@PathVariable("id") Long id) {
        try {
            servicoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
