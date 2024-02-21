package com.isaac.bookstore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.isaac.bookstore.domain.Livro;

import jakarta.validation.constraints.NotEmpty;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Campo TITULO é Obrigatorio")
	@Length(min = 3, max = 20, message = "O Campo Titulo deve ter no minimo 3 e no maximo 20")
	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
