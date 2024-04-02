package com.infnet.sistemaOficina.controller;

import com.infnet.sistemaOficina.domain.Mecanico;
import com.infnet.sistemaOficina.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    @Autowired
    private MecanicoService mecanicoService;

    @PostMapping
    public ResponseEntity<Mecanico> criarMecanico(@RequestBody Mecanico mecanico) {
        Mecanico novoMecanico = mecanicoService.salvaMecanico(mecanico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMecanico);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Mecanico>> retornaTodosMecanicos() {
        List<Mecanico> mecanicos = mecanicoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(mecanicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mecanico>> retornaMecanicoPorId(@PathVariable("id") Long id) {
        try {
            Optional<Mecanico> mecanico = mecanicoService.findById(id);
            if (mecanico.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(mecanico);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/atualiza/{id}")
    public ResponseEntity<Mecanico> atualizaMecanico(@PathVariable("id") Long id, @RequestBody Mecanico mecanico) {
        Mecanico novoMecanico = mecanicoService.update(id, mecanico);
        return ResponseEntity.status(HttpStatus.OK).body(novoMecanico);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Mecanico> deletaMecanico(@PathVariable("id") Long id) {
        try {
            mecanicoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
