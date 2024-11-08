package com.filme.controller;

import com.filme.entity.Filme;
import com.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filme")
public class FilmeCrontroller {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<Filme>> buscarTodos(){
        return ResponseEntity.ok().body(filmeService.buscarTodosFilmes());
    }

    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme){
        return ResponseEntity.status(201).body(filmeService.criarFilme(filme));
    }

    @PutMapping
    public ResponseEntity<Filme> atualizarFilme(@RequestBody Filme filme){
        return ResponseEntity.ok().body(filmeService.atualizarFilme(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFilme(@PathVariable Long id){
        filmeService.deleteFilme(id);
        return ResponseEntity.noContent().build();
    }
}
