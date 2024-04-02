package com.infnet.sistemaOficina.exception;

public class OrdemServicoNotFoundException extends RuntimeException {
    public OrdemServicoNotFoundException(String pautaId) {
        super("Pauta não encontrada ID: " + pautaId);
    }
}
