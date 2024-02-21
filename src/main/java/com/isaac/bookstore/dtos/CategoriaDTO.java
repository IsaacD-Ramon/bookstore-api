package com.isaac.bookstore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.isaac.bookstore.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	
	@NotEmpty(message = "Campo NOME é Obrigatorio")
    @Length(min = 3, max = 20, message = "O Campo Nome deve ter no minimo 3 e no maximo 20" )
	private String nome;
	    
	@NotEmpty(message = "Campo DESCRICÃO é Obrigatorio")
	@Length(min = 3, max = 200, message = "O Campo Descricão deve ter no minimo 3 e no maximo 200" )
	private String descricao;
	
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
