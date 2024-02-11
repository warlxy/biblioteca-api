package com.warley.biblioteca.repository;

import com.warley.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Emprestimo save(Emprestimo emprestimo);
}
