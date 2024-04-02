package com.infnet.sistemaOficina.controller;

import com.infnet.sistemaOficina.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/arquivo")
public class ArquivoController {

    @Autowired
    ArquivoService arquivoService;


    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile file){

        try {
            arquivoService.salvarArquivo(file);
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/uploads/")
                    .path(fileName)
                    .toUriString();

            return ResponseEntity.ok().body("Arquivo enviado com sucesso: " + url);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Nao pode ser feito o upload");
        }

    }

}
