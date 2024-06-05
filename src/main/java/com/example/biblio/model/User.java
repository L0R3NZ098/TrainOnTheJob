package com.example.biblio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nonnull
	private String nome;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Book> libri;

	public User(Long id, String nome, List<Book> libri) {
		super();
		this.id = id;
		this.nome = nome;
		this.libri = libri;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Book> getLibri() {
		return libri;
	}

	public void setLibri(List<Book> libri) {
		this.libri = libri;
	}
	
}
