package com.warley.biblioteca.controller;

import com.warley.biblioteca.exception.EmprestimoException;
import com.warley.biblioteca.model.Emprestimo;
import com.warley.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/emprestimos")
public class EmpresitmoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/adicionarEmprestimo")
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo criar(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.save(emprestimo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> buscarTodos() {
        return emprestimoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo buscarPorId(@PathVariable Long id) {
        return emprestimoService.findById(id)
                .orElseThrow(() -> new EmprestimoException(id));
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Emprestimo atualizar(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
//
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        emprestimoService.deleteById(id);
    }
}
