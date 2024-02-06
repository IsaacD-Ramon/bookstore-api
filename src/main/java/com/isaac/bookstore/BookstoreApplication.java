package com.isaac.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaac.bookstore.domain.Categoria;
import com.isaac.bookstore.domain.Livro;
import com.isaac.bookstore.repositories.CategoriaRepository;
import com.isaac.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(0, "Amor", "o livor sobre seu amor isinhaaaaaaaa");

		Livro l1 = new Livro(0, "meu grande amorrr", "sobre meu grande amor isinhaa",
		 "o livro retrato sobre o amor da autora", cat1);

		 cat1.getLivros().addAll(Arrays.asList(l1));

		 this.categoriaRepository.saveAll(Arrays.asList(cat1));
		 this.livroRepository.saveAll(Arrays.asList(l1));

	}

}
