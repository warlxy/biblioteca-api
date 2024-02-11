package com.warley.biblioteca.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long usuarioNotFoundId) {
        super("Usuário com ID " + usuarioNotFoundId + " não encontrado.");
    }
}
