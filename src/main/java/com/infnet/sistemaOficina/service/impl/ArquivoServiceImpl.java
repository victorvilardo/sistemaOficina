package com.infnet.sistemaOficina.service.impl;

import com.infnet.sistemaOficina.service.ArquivoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    private final Path root = Paths.get("uploads");

    @Override
    public void salvarArquivo(MultipartFile arquivo) {
        try {
            Files.copy(arquivo.getInputStream(), this.root.resolve(Objects.requireNonNull(arquivo.getOriginalFilename())));
        } catch (IOException e) {
            throw new RuntimeException("Nao foi possivel gravar o arquivo!" + e.getMessage());
        }

    }


}
