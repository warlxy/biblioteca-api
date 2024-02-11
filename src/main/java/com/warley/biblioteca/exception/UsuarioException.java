package com.warley.biblioteca.exception;

public class UsuarioException extends RuntimeException {

    public UsuarioException(Long usuarioId) {
        super("Usuário com ID " + usuarioId + " não é válido.");
    }

}
