package com.isaac.bookstore.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Campo TITULO é Obrigatorio")
	@Length(min = 3, max = 20, message = "O Campo Titulo deve ter no minimo 3 e no maximo 20")
	private String titulo;

	@NotEmpty(message = "Campo NOME AUTOR é Obrigatorio")
	@Length(min = 3, max = 20, message = "O Campo Nome do Autor deve ter no minimo 3 e no maximo 20")
	private String nome_autor;

	@NotEmpty(message = "Campo Texto é Obrigatorio")
	@Length(min = 3, max = 2000, message = "O Campo Texto deve ter no minimo 3 e no maximo 2000")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();

	}

	public Livro(int id, String titulo, String nome_autor, String texto, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
