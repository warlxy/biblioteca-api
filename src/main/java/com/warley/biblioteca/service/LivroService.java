package com.warley.biblioteca.service;

import com.warley.biblioteca.model.Livro;
import com.warley.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    public final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Long deleteById(Long id) {
        livroRepository.deleteById(id);
        return id;
    }
}
