package com.isaac.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.isaac.bookstore.domain.Categoria;
import com.isaac.bookstore.dtos.CategoriaDTO;
import com.isaac.bookstore.repositories.CategoriaRepository;
import com.isaac.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " + id + "tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(0);
		return repository.save(obj);

	}

	public Categoria update(Integer id, CategoriaDTO objDto) {

		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.isaac.bookstore.service.exceptions.DataIntegrityViolationException(
					"A Categoria não pode ser apaga por conta que existem livros com esssa categoria");
		}

	}

}
