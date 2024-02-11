package com.warley.biblioteca.controller;

import com.warley.biblioteca.exception.UsuarioException;
import com.warley.biblioteca.model.Usuario;
import com.warley.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/adicionarUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarTodos() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.findById(id)
                .orElseThrow(() -> new UsuarioException(id));
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
//
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
