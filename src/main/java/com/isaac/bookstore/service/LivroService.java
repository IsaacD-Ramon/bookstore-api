package com.isaac.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaac.bookstore.domain.Categoria;
import com.isaac.bookstore.domain.Livro;
import com.isaac.bookstore.repositories.LivroRepository;
import com.isaac.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " + id + "tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findByCategoria(id_cat);

	}

	public Livro update(Integer id, Livro obj) {
		Livro newobj = findById(id);
		updateData(obj, newobj);
		return repository.save(newobj);
	}

	private void updateData(Livro obj, Livro newobj) {
		newobj.setTitulo(obj.getTitulo());
		newobj.setNome_autor(obj.getNome_autor());
		newobj.setTexto(obj.getTexto());

	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(0);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

}
