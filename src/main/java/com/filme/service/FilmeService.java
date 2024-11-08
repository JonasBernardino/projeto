package com.filme.service;

import com.filme.entity.Filme;
import com.filme.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> buscarTodosFilmes(){
        return filmeRepository.findAll();
    }

    public Filme buscarFilmePorId(Long id){
        return filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não localizado"));
    }

    public Filme criarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme atualizarFilme(Filme filme) {
     this.buscarFilmePorId(filme.getId());
     return filmeRepository.save(filme);

    }

    public void deleteFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
