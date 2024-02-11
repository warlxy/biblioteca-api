package com.warley.biblioteca.exception;

public class EmprestimoException extends RuntimeException {

    public EmprestimoException(Long emprestimoId) {
        super("Emprestimo com o ID " + emprestimoId + " não disponível.");
    }
}
