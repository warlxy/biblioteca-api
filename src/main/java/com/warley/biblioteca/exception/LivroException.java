package com.warley.biblioteca.exception;

public class LivroException extends RuntimeException {

    public LivroException(Long livroId) {
        super("Livro com ID " + livroId + " não está disponível para empréstimo.");
    }
}
