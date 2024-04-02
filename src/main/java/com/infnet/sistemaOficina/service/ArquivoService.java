package com.infnet.sistemaOficina.service;

import org.springframework.web.multipart.MultipartFile;

public interface ArquivoService {

    void salvarArquivo(MultipartFile arquivo);
}
