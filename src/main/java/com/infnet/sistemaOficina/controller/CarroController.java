package com.infnet.sistemaOficina.controller;

import com.infnet.sistemaOficina.domain.Carro;
import com.infnet.sistemaOficina.domain.Veiculo;
import com.infnet.sistemaOficina.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody Carro carro) {
        Carro novoCarro = veiculoService.criarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Veiculo>> retornaTodosCarros() {
        List<Veiculo> carros = veiculoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> retornaCarroPorId(@PathVariable("id") Long id) {
        try {
            Optional<Veiculo> Carro = veiculoService.findById(id);
            if (Carro.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(Carro);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/veiculo")
    public ResponseEntity<Veiculo> adicionarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo veiculoSalvo = veiculoService.adicionarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }


//    @PutMapping("/atualiza/{id}")
//    public ResponseEntity<Carro> atualizaCarro(@PathVariable("id") Long id, @RequestBody Carro Carro) {
//        Carro novoCarro = veiculoService.atualizarCarro(id, Carro);
//        return ResponseEntity.status(HttpStatus.OK).body(novoCarro);
//    }
//

    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> deletaCarro(@PathVariable("id") Long id) {
        try {
            veiculoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
