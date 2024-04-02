package com.infnet.sistemaOficina.exception;

public class ServicoException extends RuntimeException {
    public ServicoException() {
        super("Serviço não encontrado!");
    }
}
