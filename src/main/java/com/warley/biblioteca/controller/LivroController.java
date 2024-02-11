package com.warley.biblioteca.controller;

import com.warley.biblioteca.exception.LivroException;
import com.warley.biblioteca.model.Livro;
import com.warley.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/adicionarLivro")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro criar(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarTodos() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Livro buscarPorId(@PathVariable Long id) {
        return livroService.findById(id)
                .orElseThrow(() -> new LivroException(id));
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
//
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        livroService.deleteById(id);
    }
}
