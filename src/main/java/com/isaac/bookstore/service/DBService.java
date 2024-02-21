package com.isaac.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.bookstore.domain.Categoria;
import com.isaac.bookstore.domain.Livro;
import com.isaac.bookstore.repositories.CategoriaRepository;
import com.isaac.bookstore.repositories.LivroRepository;

@Service
public class DBService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void instanciaBaseDados() {

        Categoria cat1 = new Categoria(0, "Amor", "o livor sobre seu amor isinhaaaaaaaa");

        Livro l1 = new Livro(0, "meu grande amorrr", "Lieninha",
                "o livro retrato sobre o amor da autora", cat1);

        cat1.getLivros().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(l1));

    }
}
